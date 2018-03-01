package cn.itcast.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import cn.itcast.bos.domain.SubArea;
import cn.itcast.bos.service.SubAreaService;
import cn.itcast.bos.utils.action.BaseAction;

public class SubAreaAction extends BaseAction<SubArea>{
	
	@Autowired
	private SubAreaService sas;
	
	@Action(value="SubAreaAction_add",results={@Result(name="saveSuccess",type="redirect",location="/pages/base/sub_area.html")})
	public String add(){
		
		sas.save(model);
		return "saveSuccess";
	}
	
	@Action("SubAreaAction_pageList")
	public String pageList(){
		//page2Client
		Page<SubArea>pageBean = sas.findPage(page,rows);
		page2Client(pageBean,"fixedArea","subareas");
		return null;
	}
	
	@Action("SubAreaAction_findAll")
	public String findAll(){
		//page2Client
		Page<SubArea>pageBean = sas.findPage(1,rows.MAX_VALUE);
		page2Client(pageBean,"fixedArea","subareas");
		return null;
	}
	
	@Action(value="SubAreaAction_justChartsData")
	public String justChartsData() throws IOException{
		List<Object[]> list = sas.findJustChartsData();
		
		list2Client(list);
		
		return null;
	}
	
	// 任宇强 start
	/*
	 * 通过定区编号查找关联分区
	 */
	@Action("SubAreaAction_listSubAreasByFixedAreaId")
	public String listSubAreasByFixedAreaId(){
			List<SubArea> list = sas.findSubAreasByFixedArea(model.getId());
			list2Client(list,"subareas","couriers");
			return null;
	}
	// 任宇强 end
}
