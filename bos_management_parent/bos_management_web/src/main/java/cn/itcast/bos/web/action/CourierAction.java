package cn.itcast.bos.web.action;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.bos.domain.Courier;
import cn.itcast.bos.domain.Standard;
import cn.itcast.bos.service.CourierService;
import cn.itcast.bos.service.StandardService;
import cn.itcast.bos.utils.action.BaseAction;
import net.sf.json.processors.JsonBeanProcessor;

@Controller
@Scope("prototype")

@Namespace("/")
@ParentPackage("basePackage")
public class CourierAction extends BaseAction<Courier>{

	private Courier model = new Courier();
	
	@Autowired
	private CourierService courierService;
	
	@Action(value="CourierAction_add",results={@Result(name="saveSuccess",type="redirect",location="/pages/base/courier.html")})
	public String add(){
		courierService.save(model);
		return "saveSuccess";
	}
	
	//分页查询所有的收派标准接收两个参数
	private Integer page;//当前页
	private Integer rows;//每页显示条数
	
	@Action(value="CourierAction_pageList")
	public String pageList() throws IOException{
		Specification<Courier> spec = new Specification<Courier>() {
			
			@Override
			public Predicate toPredicate(Root<Courier> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				//封装条件的集合
				List list = new ArrayList();
				
				//root表示：Courier对象
				//第二个参数没用
				//第三个参数cb：是要增加的条件
				//员工号查询条件
				if(StringUtils.isNotBlank(model.getCourierNum())){//判断不为null或空字符串
					list.add(cb.equal(root.get("courierNum").as(String.class), model.getCourierNum()));
				}
				//部门查询条件
				if(StringUtils.isNotBlank(model.getCompany())){//判断不为null或空字符串
					list.add(cb.like(root.get("company").as(String.class), model.getCompany()));
				}
				//类型查询条件
				if(StringUtils.isNotBlank(model.getType())){//判断不为null或空字符串
					list.add(cb.like(root.get("type").as(String.class), model.getType()));
				}
				//收派标准条件  根据id判断
				if(model.getStandard()!=null&&model.getStandard().getId()!=null){
					//关联查询
					Join<Object, Object> join = root.join("standard");
					list.add(cb.equal(join.get("id").as(Integer.class),model.getStandard().getId()));
				}
				if(list.size()==0){
					return null;
				}else{
					Predicate[] p = new Predicate[list.size()];
					list.toArray(p);
					return cb.and(p);
				}
			}
		};
		Page<Courier> pageBean = courierService.findByPage(spec,page,rows);
		//将pageBean的rows和total存到map集合中
		Map map = new HashMap();
		
		map.put("rows", pageBean.getContent());
		map.put("total", pageBean.getTotalElements());
		
		//创建生成属性过滤器  使json中不生成takeTime、fixedAreas对象
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
		
		//filter.getExcludes().add("standard");
		filter.getExcludes().add("takeTime");
		filter.getExcludes().add("fixedAreas");
		//还需要设置禁止回环引用 因为阿里的JSON工具类  在查询过一个对象的时候  在下一次查询的时候会自动生成该对象的代理对象，不会再次查询
		//保证多次生成同一个对象的json  每次都正常生成
		String json = JSON.toJSONString(map,filter,SerializerFeature.DisableCircularReferenceDetect);
		//设置格式和编码
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json); 
		return null;
	}
	
	private String fixareaId;
	
	@Action("CourierAction_getLinkedCourier")
	public String getLinkedCustomer(){
		
		List<Courier>list = courierService.getLinkedCourier(Integer.parseInt(fixareaId));
		
		list2Client(list);
		
		return null;
	}
	
	@Action(value="CourierAction_findAll")
	public String findAll() throws IOException{
		
		Page<Courier> pageBean = courierService.findByPage(null,1,Integer.MAX_VALUE);
		//将pageBean的rows和total存到map集合中
		String json = JSON.toJSONString(pageBean.getContent());
		//设置格式和编码
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}
	//接收页面参数ids
	private String ids;
	
	@Action(value="CourierAction_toDeltag")
	public String toDeltag() throws Exception {
		String[] idsStrArray = ids.split(",");
		
		Integer[] idsArray = new Integer[idsStrArray.length];
		
		for(int i = 0 ; i < idsStrArray.length;i++){
			idsArray[i] = Integer.parseInt(idsStrArray[i]);
			//System.out.println(idsArray[i]);
		}
		courierService.delete(idsArray);
		return null;
	}
	
	private String idss;
	
	@Action("CourierAction_toRestore")
	public String restore(){
		String[] idsStrArray = idss.split(",");
		
		Integer[] idsArray = new Integer[idsStrArray.length];
		
		for(int i = 0 ; i < idsStrArray.length;i++){
			idsArray[i] = Integer.parseInt(idsStrArray[i]);
			//System.out.println(idsArray[i]);
		}
		courierService.restore(idsArray);
		return null;
	}
	
	@Override
	public Courier getModel() {
		return model;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}


	public String getIds() {
		return ids;
	}


	public void setIds(String ids) {
		this.ids = ids;
	}


	public String getIdss() {
		return idss;
	}


	public void setIdss(String idss) {
		this.idss = idss;
	}
	
}
