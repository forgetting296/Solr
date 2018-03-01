package cn.itcast.bos.web.action;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.aspectj.internal.lang.annotation.ajcPrivileged;
import org.hibernate.engine.spi.CascadingActions.BaseCascadingAction;
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

import cn.itcast.bos.domain.Area;
import cn.itcast.bos.domain.Courier;
import cn.itcast.bos.domain.Standard;
import cn.itcast.bos.service.AreaService;
import cn.itcast.bos.service.CourierService;
import cn.itcast.bos.service.StandardService;
import cn.itcast.bos.utils.FileUtils;
import cn.itcast.bos.utils.PinYin4jUtils;
import cn.itcast.bos.utils.action.BaseAction;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.json.processors.JsonBeanProcessor;


public class AreaAction extends BaseAction<Area>{

	@Autowired
	private AreaService areaService;
	
	private File xls;
	//private String xlsFileName;
	@Action(value="AreaAction_upload")
	public String uploadFile() throws FileNotFoundException, IOException{
		//创建list
	List<Area> list = new ArrayList<>();
	//解析excel
		//1 读取xls文件,获得文档对象
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(xls));
		//2 从文档中获得表格对象
		HSSFSheet sheet = wb.getSheetAt(0);
		//5 获得每一个数据行以及其中的内容
		//获得最后一行的行号
		int lastRowNum = sheet.getLastRowNum();
		//遍历获得每行内容
		for(int i = 1; i < lastRowNum ; i++){
			//创建封装数据的area对象
			//取出每个区域属性,封装为Area对象
			Area area = new Area();
			//获得当前遍历的数据行
			HSSFRow row = sheet.getRow(i);
			//取出单元格内容放入area对象
			area.setId(row.getCell(0).getStringCellValue());
			area.setProvince(row.getCell(1).getStringCellValue());
			area.setCity(row.getCell(2).getStringCellValue());
			area.setDistrict(row.getCell(3).getStringCellValue());
			area.setPostcode(row.getCell(4).getStringCellValue());
			//将省|市|区 名称的最后一个字删除
			String province = area.getProvince().substring(0, area.getProvince().length()-1);
			String city = area.getCity().substring(0, area.getCity().length()-1);
			String district = area.getDistrict().substring(0, area.getDistrict().length()-1);
			//生成全拼和简码
			//生成全拼
			area.setCitycode(PinYin4jUtils.hanziToPinyin(city, ""));
			//生成首字母
			String shortCode = StringUtils.join(PinYin4jUtils.getHeadByString(province+city+district),"");
			area.setShortcode(shortCode);
			//将area添加到集合中
			list.add(area);
		}
	//调用Service保存list
		areaService.saveAll(list);
		return null;
	}
	
	@Action("AreaAction_export")
	//导出页面数据生成Excel表格
	public String export() throws Exception{
		//查询所有的区域数据
		List<Area>list = areaService.findAll();
		//使用POI将数据写入到Excel
		HSSFWorkbook workBook = new HSSFWorkbook();//在内存中创建一个表格文件
		HSSFSheet sheet = workBook.createSheet("区域数据");//在表格中创建一个标签页sheet
		HSSFRow hssfRow = sheet.createRow(0);//创建行  作为标题行
		hssfRow.createCell(0).setCellValue("省");//创建列   并且赋值
		hssfRow.createCell(1).setCellValue("市");//创建列   并且赋值
		hssfRow.createCell(2).setCellValue("区");//创建列   并且赋值
		hssfRow.createCell(3).setCellValue("邮编");//创建列   并且赋值
		hssfRow.createCell(4).setCellValue("简码");//创建列   并且赋值
		hssfRow.createCell(5).setCellValue("城市编码");//创建列   并且赋值
		//遍历查询到的区域集合
		for (Area a : list) {
			HSSFRow row = sheet.createRow(sheet.getLastRowNum()+1);//当前最后一行的下一行   就是再创建一行
			row.createCell(0).setCellValue(a.getProvince());
			row.createCell(1).setCellValue(a.getCity());
			row.createCell(2).setCellValue(a.getDistrict());
			row.createCell(3).setCellValue(a.getPostcode());
			row.createCell(4).setCellValue(a.getCitycode());
			row.createCell(5).setCellValue(a.getShortcode());
		}
		//提供下载   重写两个头  回写一个流
		//先提供一个输出流
		ServletOutputStream outputStream = ServletActionContext.getResponse().getOutputStream();
		ServletActionContext.getResponse().setContentType("application/vnd.ms-excel");
		String agent = ServletActionContext.getRequest().getHeader("User-Agent");
		String filename = "区域数据.xls";
		filename= FileUtils.encodeDownloadFilename(filename, agent);
		ServletActionContext.getResponse().setHeader("content-disposition", "attachment;filename="+filename);
		workBook.write(outputStream);
		return null;
	}
	
	/*
	 * 收派标准分页列表
	 */
	@Action("AreaAction_pageList")
	//@RequiresPermissions("hehe")
	public String pageList() throws Exception {
		//1 调用Service查询PageBean
		Page<Area> pageBean = areaService.findPageBean(page,rows);
		page2Client(pageBean,"subareas");
		return null;
	}
	
	//接收下拉选的提示参数
	private String q;
	
	@Action(value="AreaAction_page2List")
	public String page2List() throws IOException{
		
		List<Area>list = null;
		if(StringUtils.isNotBlank(q)){
			//条件查询
			list = areaService.find(q);
		}else{
			list=areaService.findPageBean(1, Integer.MAX_VALUE).getContent();
		}
		list2Client(list,"subareas");
		//Page<Area>pageBean = areaService.findPageBean(1, Integer.MAX_VALUE);
		//list2Client(pageBean.getContent());
		return null;
	}
	
	@Action(value="AreaAction_add",results={@Result(name="success",type="redirect",location="/pages/base/area.html")})
	public String add(){
		model.setId("QY066");
		areaService.save(model);
		
		return "success";
	}
	
	@Autowired
	private DataSource dataSource;
	
	@Action("AreaAction_exportPDF")
	//将页面数据导出成一个PDF文件
	public String exportPDF() throws Exception{
		// 读取 jrxml 文件
		String jrxml = ServletActionContext.getServletContext().getRealPath("/jasper/report1.jrxml");
		// 准备需要数据
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("company", "传智播客");
		// 准备需要数据
		JasperReport report = JasperCompileManager.compileReport(jrxml);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, dataSource.getConnection());

		HttpServletResponse response = ServletActionContext.getResponse();
		OutputStream ouputStream = response.getOutputStream();
		// 设置相应参数，以附件形式保存PDF
		response.setContentType("application/pdf");
		response.setCharacterEncoding("UTF-8");
		String agent = ServletActionContext.getRequest().getHeader("User-Agent");
		response.setHeader("Content-Disposition", "attachment; filename=" + FileUtils.encodeDownloadFilename("工作单.pdf",agent));
		// 使用JRPdfExproter导出器导出pdf
		JRPdfExporter exporter = new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
		exporter.exportReport();// 导出
		ouputStream.close();// 关闭流
		return null;
	}
	
	@Action("AreaAction_highchars")
	public String highchars(){
		
		List<Object[]> list = areaService.findHighChartsData();
		
		list2Client(list);
		
		return null;
	}
	
	
	public File getXls() {
		return xls;
	}

	public void setXls(File xls) {
		this.xls = xls;
	}
	
	public String getQ() {
		return q;
	}


	public void setQ(String q) {
		this.q = q;
	}
	
}
