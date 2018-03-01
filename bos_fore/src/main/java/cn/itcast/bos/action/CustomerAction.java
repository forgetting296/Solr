package cn.itcast.bos.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.aliyuncs.exceptions.ClientException;
import com.opensymphony.xwork2.ActionContext;

import cn.itcast.bos.utils.CheckCodeUtils;
import cn.itcast.bos.utils.MailUtils;
import cn.itcast.bos.utils.SmsUtils;
import cn.itcast.bos.utils.action.BaseAction;
import cn.itcast.crm.service.Customer;
import cn.itcast.crm.service.CustomerServiceImpl;

@Results({@Result(name="registSuccess",type="redirect",location="/signup-success.html"),
		  @Result(name="activeSuccess",type="redirect",location="/login.html"),
		  @Result(name="loginSuccess",type="redirect",location="/index.html"),
		  @Result(name="error",location="/error.jsp")})
public class CustomerAction extends BaseAction<Customer>{
	
	@Autowired
	private CustomerServiceImpl cs;
	
	@Autowired
	private RedisTemplate<String, String>rt;
	
	private String mailInput;
	
	@Action("CustomerAction_checkMail")
	public String checkMail(){
		Map map = new HashMap();
		Customer c = cs.findByEmail(mailInput);
		if(c==null){
			//说明该邮箱没有使用过
			map.put("type", "success");
			map.put("msg", "ok！");
			map2Client(map);
		}else{
			map.put("type", "error");
			map.put("msg", "手机号已经被注册！");
			map2Client(map);
		}
		return null;
	}
	
	@Action("CustomerAction_sendCheckCode")
	public String sendCheckCode() throws ClientException{
		
		Map map = new HashMap();
		if(checkType.equals("regist")){
			//先要校验这个电话号码是否已经注册过了   即数据库中如果有这个电话号码就已经注册过了
			Customer existCustomer = cs.findByTelephone(model.getTelephone());
			if(existCustomer!=null){
				//说明已经注册过了 {type:error,msg:手机号已经被注册!}
				map.put("type", "error");
				map.put("msg", "手机号已经被注册！");
				map2Client(map);
				return null;
			}else{
				//如果可以执行到这里  说明手机号可以用  发送验证码
				final String checkCode = CheckCodeUtils.getCheckCode(6);
				System.out.println(checkCode);
				//SmsUtils.sendSms(model.getTelephone(),checkCode);
				
				//亢宏杰
				//使用jms发送消息  通知邮件发送项目发送短信
				jt.send("bos_fore.phone", new MessageCreator() {
					
					@Override
					public Message createMessage(Session session) throws JMSException {
						MapMessage mapMessage = session.createMapMessage();
						mapMessage.setString("telephone", model.getTelephone());
						mapMessage.setString("checkCode", checkCode);
						return mapMessage;
					}
				});
				
				//亢宏杰end
				//将生成的验证码放入session域中  方便之后校验   防止bug  使用填写的电话作为键
				ActionContext.getContext().getSession().put(model.getTelephone(), checkCode);
				
				map.put("type", "success");
				map.put("msg", "ok！");
				map2Client(map);
			}
		}else{
			final String checkCode = CheckCodeUtils.getCheckCode(6);
			System.out.println(checkCode);
			//SmsUtils.sendSms(model.getTelephone(),checkCode);
			
			//亢宏杰
			//使用jms发送消息  通知邮件发送项目发送短信
			jt.send("bos_fore.phone", new MessageCreator() {
				
				@Override
				public Message createMessage(Session session) throws JMSException {
					MapMessage mapMessage = session.createMapMessage();
					mapMessage.setString("telephone", model.getTelephone());
					mapMessage.setString("checkCode", checkCode);
					return mapMessage;
				}
			});
			
			//亢宏杰end
			//将生成的验证码放入session域中  方便之后校验   防止bug  使用填写的电话作为键
			ActionContext.getContext().getSession().put(model.getTelephone(), checkCode);
			
			map.put("type", "success");
			map.put("msg", "ok！");
			map2Client(map);
		}
		
		
		return null;
		//因为登陆的时候还可以通过邮箱登陆   还要校验一下邮箱是否已经存在
		//cs.findByEmail()
		
	}
	//注册的手机验证码
	private String checkCode;
	
	@Autowired
	private JmsTemplate jt;
	
	@Action(value="CustomerAction_regist")
	public String regist(){
		
		//校验验证码
		String key = (String) ActionContext.getContext().getSession().get(model.getTelephone());
		Customer customer = cs.findByEmail(model.getEmail());
		if(customer!=null){
			ActionContext.getContext().getSession().put("msg", "该邮箱已经注册！");
			return "error";
		}
		if(key!=null&&checkCode!=null&&checkCode.equals(key)){
			model.setType(0);
			cs.regist(model);
			//生成激活码
			final String activeCode = RandomStringUtils.randomNumeric(32);
			//将激活码保存到redis  并设置时间是24小时
			rt.opsForValue().set("activeCode", activeCode, 24, TimeUnit.HOURS);
			//设置邮件内容
			//调用mailUtils发送邮件
			//String content = "尊敬的用户您好，请于24小时以内完成邮箱账户的绑定，点击下面的地址完成绑定:<a href='"+MailUtils.activeUrl+"?telephone="+model.getTelephone()+"&activeCode="+activeCode+"'>速运快递邮箱绑定地址</a>";
			//MailUtils.sendMail("速运快递激活邮件", content, model.getEmail());
			//使用jms发送消息  通知邮件发送项目发送邮件
			jt.send("bos_fore.mail", new MessageCreator() {
				
				@Override
				public Message createMessage(Session session) throws JMSException {
					MapMessage mapMessage = session.createMapMessage();
					mapMessage.setString("title", "速运快递激活邮件");
					mapMessage.setString("content", "尊敬的用户您好，请于24小时以内完成邮箱账户的绑定，点击下面的地址完成绑定:<a href='"+MailUtils.activeUrl+"?telephone="+model.getTelephone()+"&activeCode="+activeCode+"'>速运快递邮箱绑定地址</a>");
					mapMessage.setString("to", model.getEmail());
					return mapMessage;
				}
			});
			
			
			return "registSuccess";
		}else{
			ActionContext.getContext().getSession().put("msg", "验证码错误");
			return "error";
		}
	}
	//邮箱激活的激活码
	private String activeCode;
	
	@Action("CustomerAction_activeMail")
	public String activeMail(){
		//获取电话号码
		String telephone = model.getTelephone();
		//从redis中获取activeCode
		String redisActiveCode = rt.opsForValue().get("activeCode");
		//删除redis中的激活码
		rt.opsForValue().set("activeCode","",1,TimeUnit.MILLISECONDS);
		if(redisActiveCode!=null&&activeCode!=null&&redisActiveCode.equals(activeCode)){
			//进来了就说明页面和输入的激活码一致
			Customer customer = cs.findByTelephone(model.getTelephone());
			if(customer==null){
				ActionContext.getContext().getSession().put("msg", "该电话号码还未注册");
				return "error";
			}
			if(customer.getType()!=1||customer.getType()==null){
				//说明这个邮箱还没有被注册
				cs.updateType(model.getTelephone());
				return "activeSuccess";
			}else{
				ActionContext.getContext().getSession().put("msg", "该用户已经激活过了！");
				return "error";
			}
		}else{
			ActionContext.getContext().getSession().put("msg", "激活码错误");
			return "error";
		}
	}
	
	private String validateCode;
	private Integer article;
	private String checkType;
	//登陆方法
	@Action("CustomerAction_login")
	public String login(){
		if(article==0){
			//先校验验证码
			String sessionCode = (String) ActionContext.getContext().getSession().get("validateCode");
			if(validateCode!=null&&validateCode.equals(sessionCode)){
				//验证码填写正确
				//校验邮箱
				Customer customer = cs.findByEmail(model.getEmail());
				if(customer!=null){
					//用户名没有问题
					//校验用户是否激活
					if(customer.getType()==1){
						//校验完成
						ActionContext.getContext().getSession().put("loginCustomer", customer);
						return "loginSuccess";
					}else{
						//用户未激活
						ActionContext.getContext().getSession().put("msg", "用户还没有激活");
						return "error";
					}
				}else{
					//还没有注册
					ActionContext.getContext().getSession().put("msg", "用户还没有注册");
					return "error";
				}
			}else{
				ActionContext.getContext().getSession().put("msg", "验证码输入错误");
				return "error";
			}
		}else{
			//使用手机号登陆
			//先获取session域中的登陆验证码
			String codeSession = (String) ActionContext.getContext().getSession().get(model.getTelephone());
			if(checkCode!=null&&checkCode.equals(codeSession)){
				//验证码填写正确
				//校验手机号码
				Customer customer = cs.findByTelephone(model.getTelephone());
				if(customer!=null){
					//有对象  校验是否激活
					if(customer.getType()==1){
						//将客户对象cunrusession域中
						ActionContext.getContext().getSession().put("loginCustomer", customer);
						return "loginSuccess";
					}else{
						//用户还没有激活
						ActionContext.getContext().getSession().put("msg", "用户还没有激活");
						return "error";
					}
				}else{
					//手机号码还没有注册
					ActionContext.getContext().getSession().put("msg", "手机号码还没有注册");
					return "error";
				}
			}else{
				ActionContext.getContext().getSession().put("msg", "验证码错误");
				return "error";
			}
		}
		
	}
	
	
	public String getCheckCode() {
		return checkCode;
	}
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
	public String getActiveCode() {
		return activeCode;
	}
	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}
	public String getCheckType() {
		return checkType;
	}
	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}
	public String getMailInput() {
		return mailInput;
	}
	public void setMailInput(String mailInput) {
		this.mailInput = mailInput;
	}
	public String getValidateCode() {
		return validateCode;
	}
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	public Integer getArticle() {
		return article;
	}
	public void setArticle(Integer article) {
		this.article = article;
	}
}
