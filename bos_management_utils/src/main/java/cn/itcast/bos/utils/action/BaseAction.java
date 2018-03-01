package cn.itcast.bos.utils.action;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;



@Controller
@Scope("prototype")

@Namespace("/")
@ParentPackage("basePackage")
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	
	
	protected T model;
	
	public BaseAction() {
		//获得可获得泛型的父类
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得泛型的类型  返回一个数组   由于我们确定我们的泛型只有一个  所以可以直接取第一个元素 
		Class clazz = (Class) type.getActualTypeArguments()[0];
		//初始化model
		try {
			model = (T) clazz.newInstance();
		} catch (InstantiationException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		}
	}
	@Override
	public T getModel() {
		
		return model;
	}
	
	//分页查询所有的收派标准接收两个参数
		protected Integer page;//当前页
		protected Integer rows;//每页显示条数
		
		public String page2Client(Page<T>pageBean,String...enCludeStr){
			//将pageBean的rows和total存到map集合中
			Map map = new HashMap();
			
			map.put("rows", pageBean.getContent());
			map.put("total", pageBean.getTotalElements());
			
			//创建生成属性过滤器  使json中不生成takeTime、fixedAreas对象
			SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
			
			filter.getExcludes().addAll(Arrays.asList(enCludeStr));
			//还需要设置禁止回环引用 因为阿里的JSON工具类  在查询过一个对象的时候  在下一次查询的时候会自动生成该对象的代理对象，不会再次查询
			//保证多次生成同一个对象的json  每次都正常生成
			String json = JSON.toJSONString(map,filter,SerializerFeature.DisableCircularReferenceDetect);
			//设置格式和编码
			ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
			try {
				ServletActionContext.getResponse().getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		
		public String map2Client(Map map){
			//将pageBean的rows和total存到map集合中
			String json = JSON.toJSONString(map);
			//设置格式和编码
			ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
			try {
				ServletActionContext.getResponse().getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		//抽取查询所有方法  用于下拉选
		public String list2Client(List list,String...enCludeStr){
			
			SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
			
			filter.getExcludes().addAll(Arrays.asList(enCludeStr));
			String json = JSON.toJSONString(list,filter,SerializerFeature.DisableCircularReferenceDetect);
			//设置格式和编码
			ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
			try {
				ServletActionContext.getResponse().getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
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
}
