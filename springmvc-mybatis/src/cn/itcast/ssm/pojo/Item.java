package cn.itcast.ssm.pojo;

import java.util.Date;

public class Item {
	// 商品id
	private int id; 
	// 商品名称
	private String name;
	// 商品价格
	private Float price;
	// 商品创建时间
	private Date createtime;
	// 商品描述
	private String detail;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
	
	
}
