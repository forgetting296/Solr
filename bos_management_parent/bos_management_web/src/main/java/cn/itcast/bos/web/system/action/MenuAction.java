package cn.itcast.bos.web.system.action;

import java.io.IOException;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;

import cn.itcast.bos.domain.system.Menu;
import cn.itcast.bos.domain.system.User;
import cn.itcast.bos.service.system.MenuService;
import cn.itcast.bos.utils.action.BaseAction;


public class MenuAction extends BaseAction<Menu>{
	
	@Autowired
	private MenuService ms;
	
	@Action("menuAction_list")
	public String findToList() throws IOException{
		
		List<Menu> list = ms.findAll();
		
		list2Client(list, "parentMenu","roles");
		return null;
	}
	@Action("MenuAction_list")
	public String findToList2() throws IOException{
		
		List<Menu> list = ms.findAll();
		
		list2Client(list,"parentMenu","roles","childrenMenus");
		return null;
	}
	@Action(value="menuAction_add",results={@Result(name="add",type="redirect",location="/pages/system/menu.html")})
	public String add(){
		
		ms.save(model);
		
		return "add";
	}
	
	@Action("menuAction_showMenu")
	public String showMenu(){
		//获取登录用户   查出对应的菜单
		//User user = (User) ActionContext.getContext().getSession().get("loginUser");
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		List<Menu>list = ms.findByUser(user);
		list2Client(list, "roles","childrenMenus","parentMenu","children");
		return null;
	}
}
