package cn.itcast.bos.web.system.action;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.bos.domain.system.User;
import cn.itcast.bos.service.system.UserService;
import cn.itcast.bos.utils.action.BaseAction;

@Results({@Result(name="toIndex",type="redirect",location="/index.html"),
		@Result(name="toList",type="redirect",location="/pages/system/userlist.html")})
public class UserAction extends BaseAction<User>{
	
	@Autowired
	private UserService us;
	
	@Action("UserAction_login")
	public String login(){
		//获得subject对象   subject就是操作的入口
		Subject subject = SecurityUtils.getSubject();
		//封装用户名和密码到token中
		UsernamePasswordToken token = new UsernamePasswordToken(model.getUsername(), model.getPassword());
		//调用subject的login方法
		subject.login(token);
		//重定向到首页
		return "toIndex";
	}
	
	@Action("UserAction_list")
	public String list(){
		
		List<User>list = us.findAll();
		list2Client(list, "roles");
		return null;
	}
	
	private List<Integer>roleIds;
	
	@Action("UserAction_add")
	public String add(){
		
		//得到多选框的角色id集合
		us.save(model,roleIds);
		
		return "toList";
	}
	
	@Action(value="userAction_logout",results={@Result(name="success",type="redirect",location="/login.html")})
	public String logout(){
		
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "success";
	}
	
	public List<Integer> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}
	
}
