package cn.itcast.bos.web.take_delivery.action;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.PackageBasedActionConfigBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
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
import cn.itcast.bos.domain.TakeTime;
import cn.itcast.bos.domain.take_delivery.WayBill;
import cn.itcast.bos.service.AreaService;
import cn.itcast.bos.service.CourierService;
import cn.itcast.bos.service.StandardService;
import cn.itcast.bos.service.TakeTimeService;
import cn.itcast.bos.service.take_delivery.WayBillService;
import cn.itcast.bos.utils.FileUtils;
import cn.itcast.bos.utils.PinYin4jUtils;
import cn.itcast.bos.utils.action.BaseAction;
import net.sf.json.processors.JsonBeanProcessor;

public class WayBillAction extends BaseAction<WayBill>{
	
	@Autowired
	private WayBillService wbs;
	
	@Action("WayBillAction_findByPage")
	public String findByPage(){
		Page<WayBill> pageBean= wbs.findByPage(page,rows);
		
		page2Client(pageBean, "sendArea","order","recArea");
		
		return null;
	}
	
	@Action("WayBillAction_add")
	public String add(){
		
		Integer id = wbs.save(model);
		
		try {
			ServletActionContext.getResponse().getWriter().print(id+"");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 运单导入之模板下载功能
	 * 2018-01-29 刘桂远
	 * @throws IOException 
	 * */
	@Action("wayBillAction_download")
	public String download() throws IOException{
		// 1.0 创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wb = new HSSFWorkbook();
		// 1.1 创建新的sheet对象(excel的表单)
		HSSFSheet sheet = wb.createSheet("运单导入模板");
		// 1.2 在sheet里创建标题行(参数为行索引,可以是0-65535)
		HSSFRow titleRow = sheet.createRow(0);
		// 1.3 创建单元格(参数为列索引，可以是0-255)，并设置单元格内容
		HSSFCell cell = titleRow.createCell(0);
		cell.setCellValue("顺丰快递详情单");
		// 1.4 合并单元格(合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列 )
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 14));		
		// 设置单元格样式
		HSSFCellStyle cellStyle = wb.createCellStyle();//单元格样式对象
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 居中对齐
		// 设置单元格的行高和列宽
		sheet.setDefaultRowHeightInPoints(20); //列高 ：sheet.setDefaultRowHeightInPoints()	
		// 设置字段
		// 创建HSSFFont对象
		HSSFFont fontStyle = wb.createFont();
		fontStyle.setFontName("宋体");
		fontStyle.setFontHeightInPoints((short)15);//设置字体高度
		fontStyle.setColor(HSSFColor.BLUE.index);//设置字体颜色
		fontStyle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//设置粗体
		//fontStyle.setItalic(true);//设置倾斜
		//fontStyle.setUnderline(HSSFFont.U_SINGLE);//设置下划线
		// 将字体设置到单元格样式
			cellStyle.setFont(fontStyle);
			// 将单元格样式应用到单元格
			titleRow.setRowStyle(cellStyle);
			cell.setCellStyle(cellStyle);
		// 1.4 在sheet里创建第二行
		HSSFRow contextRow = sheet.createRow(1);
			// 创建单元格并设置单元格中的内容		
			contextRow.createCell(0).setCellValue("运单编号");
			contextRow.createCell(1).setCellValue("寄件人姓名");
			contextRow.createCell(2).setCellValue("寄件人电话");		
			contextRow.createCell(3).setCellValue("寄件人公司");
			contextRow.createCell(4).setCellValue("寄件人地址");
			contextRow.createCell(5).setCellValue("收件人姓名");
			contextRow.createCell(6).setCellValue("收件人电话");
			contextRow.createCell(7).setCellValue("收件人公司");
			contextRow.createCell(8).setCellValue("收件人地址");
			contextRow.createCell(9).setCellValue("快递产品类型");
			contextRow.createCell(10).setCellValue(" 托寄物类型");
			contextRow.createCell(11).setCellValue("支付类型编号");
			contextRow.createCell(12).setCellValue("托寄物重量");
			contextRow.createCell(13).setCellValue("托寄物原件数");
			contextRow.createCell(14).setCellValue("备注");			
			/*// 设置单元格样式
			cellStyle = wb.createCellStyle();//单元格样式对象
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 居中对齐
			// 设置单元格的行高和列宽
			sheet.setDefaultRowHeightInPoints(20); //行高 ：sheet.setDefaultRowHeightInPoints()
*/			//第一个参数代表列id(从0开始),第2个参数代表宽度值
			sheet.setColumnWidth(0, 2200);
			sheet.setColumnWidth(1, 2800);
			sheet.setColumnWidth(2, 2800);
			sheet.setColumnWidth(3, 2800);
			sheet.setColumnWidth(4, 2800);
			sheet.setColumnWidth(5, 2800);
			sheet.setColumnWidth(6, 2800);
			sheet.setColumnWidth(7, 2800);
			sheet.setColumnWidth(8, 2800);
			sheet.setColumnWidth(9, 3000);
			sheet.setColumnWidth(10, 3000);
			sheet.setColumnWidth(11, 3000);
			sheet.setColumnWidth(12, 3000);
			sheet.setColumnWidth(13, 3000);
			sheet.setColumnWidth(14, 2000);	
			/*// 设置字段
			// 创建HSSFFont对象
			fontStyle.setFontName("黑体");
			fontStyle.setFontHeightInPoints((short)15);//设置字体高度
			fontStyle.setColor(HSSFColor.BLUE.index);//设置字体颜色
			fontStyle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//设置粗体
			// 将字体设置到单元格样式
			// 将单元格样式应用到单元格
			cellStyle.setFont(fontStyle);			
			contextRow.setRowStyle(cellStyle);
			cell.setCellStyle(cellStyle);*/
		// 1.5 指定响应正文内容类型
		ServletActionContext.getResponse().setContentType("application/vnd.ms-excel");
		// 1.6 指定正文内容作为附件下载
		String agent = ServletActionContext.getRequest().getHeader("User-Agent");
		ServletActionContext.getResponse()
					.setHeader("Content-Disposition", 
					"attachment;filename="+FileUtils.encodeDownloadFilename("工作单导入模板.xls", agent));
		// 1.7 写到浏览器
		wb.write(ServletActionContext.getResponse().getOutputStream());		
		return null;
	}
	//接收名为xls的上传文件内容
	private File xls;
	private String xlsFileName;
	/**
	 * 运单导入模块之批量导入功能
	 * 2018-01-30 刘桂远
	 * */
	@Action("waybillAction_batchImport")
	public String batchImport() throws IOException{
		//String path = xls.getPath();
		//System.out.println(path);
		//String fileName = "C:\\Users\\Administrator\\Desktop\\运单批量导入\\工作单导入模板 .xls";;
		//String fileName = xls.getName();//获取上传的文件名称
		System.out.println(xlsFileName);
		if(xlsFileName.endsWith("xls")) {
			read2003Excel(xls);
		}else if(xlsFileName.endsWith("xlsx")) {
			 read2007Excel(xls);
		}else {
			throw new IOException("不支持的文件类型");
		}
		/*String extension = xlsFileName.lastIndexOf(".") == -1 ? "" : xlsFileName  
                .substring(xlsFileName.lastIndexOf(".") + 1);
		if ("xls".equals(extension)) { 
           read2003Excel(xls);  	
        } else if ("xlsx".equals(extension)) {  
           read2007Excel(xls);  
        } else {  
            throw new IOException("不支持的文件类型");  
        }*/
		return null; 
    }
	private void read2003Excel(File xls) throws IOException, FileNotFoundException {
		// 1.0 创建list
		List<WayBill> list = new ArrayList<>();
		// 1.1 读取xls文件，获得文档对象
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(xls));
		// 1.2 从文档中获得表格对象
		HSSFSheet sheet = wb.getSheetAt(0);
		// 1.3 获得每一个数据行以及其中的内容
		int lastRowNum = sheet.getLastRowNum();
		System.out.println(lastRowNum);
		// 1.4 遍历获得每一行的内容
		for (int i = 2; i < lastRowNum; i++) {
			WayBill wayBill = new WayBill();
			// 取出当前遍历的数据行
			HSSFRow row = sheet.getRow(i);
			// 取出单元格内容并放入到wayBill对象中
			System.out.println(row.getCell(0)+"");
			wayBill.setWayBillNum(row.getCell(0)+"");
			wayBill.setSendName(row.getCell(1).getStringCellValue());
			wayBill.setSendMobile(row.getCell(2)+"");
			wayBill.setSendCompany(row.getCell(3).getStringCellValue());
			wayBill.setSendAddress(row.getCell(4).getStringCellValue());
			wayBill.setRecName(row.getCell(5).getStringCellValue());
			wayBill.setRecMobile(row.getCell(6)+"");
			wayBill.setRecCompany(row.getCell(7).getStringCellValue());
			wayBill.setRecAddress(row.getCell(8).getStringCellValue());
			wayBill.setSendProNum(row.getCell(9).getStringCellValue());
			wayBill.setGoodsType(row.getCell(10).getStringCellValue());
			wayBill.setPayTypeNum(row.getCell(11)+"");
			wayBill.setWeight(row.getCell(12).getNumericCellValue());
			wayBill.setNum(row.getCell(13).getColumnIndex());
			wayBill.setRemark(row.getCell(14).getStringCellValue());
			list.add(wayBill);
		}
		// 调用service保存
		wbs.saveAll(list);
	}  
	private void read2007Excel(File xls) throws IOException, FileNotFoundException {
		// 1.0 创建list
		List<WayBill> list = new ArrayList<>();
		// 1.1 读取xls文件，获得文档对象
		XSSFWorkbook xwb = new XSSFWorkbook(new FileInputStream(xls));
		// 1.2 从文档中获得表格对象
		XSSFSheet sheet = xwb.getSheetAt(0);
		// 1.3 获得每一个数据行以及其中的内容
		int lastRowNum = sheet.getLastRowNum();
		System.out.println(lastRowNum);
		// 1.4 遍历获得每一行的内容
		for (int i = 2; i < lastRowNum; i++) {
			WayBill wayBill = new WayBill();
			// 取出当前遍历的数据行
			XSSFRow row = sheet.getRow(i);
			// 取出单元格内容并放入到wayBill对象中
			System.out.println(row.getCell(0)+"");
			wayBill.setWayBillNum(row.getCell(0)+"");
			wayBill.setSendName(row.getCell(1).getStringCellValue());
			wayBill.setSendMobile(row.getCell(2)+"");
			wayBill.setSendCompany(row.getCell(3).getStringCellValue());
			wayBill.setSendAddress(row.getCell(4).getStringCellValue());
			wayBill.setRecName(row.getCell(5).getStringCellValue());
			wayBill.setRecMobile(row.getCell(6)+"");
			wayBill.setRecCompany(row.getCell(7).getStringCellValue());
			wayBill.setRecAddress(row.getCell(8).getStringCellValue());
			wayBill.setSendProNum(row.getCell(9).getStringCellValue());
			wayBill.setGoodsType(row.getCell(10).getStringCellValue());
			wayBill.setPayTypeNum(row.getCell(11)+"");
			wayBill.setWeight(row.getCell(12).getNumericCellValue());
			wayBill.setNum(row.getCell(13).getColumnIndex());
			wayBill.setRemark(row.getCell(14).getStringCellValue());
			list.add(wayBill);
		}
		// 调用service保存
		wbs.saveAll(list);
	}  
	
	@Action("wayBillAction_pageList")
	public String pageList(){
		Page<WayBill> pageBean = wbs.findByPage(page, rows);
		page2Client(pageBean,"order");
		return null;
		
	}
	
	public File getXls() {
		return xls;
	}
	public void setXls(File xls) {
		this.xls = xls;
	}
	public String getXlsFileName() {
		return xlsFileName;
	}
	public void setXlsFileName(String xlsFileName) {
		this.xlsFileName = xlsFileName;
	}
}
