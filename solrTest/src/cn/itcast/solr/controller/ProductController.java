package cn.itcast.solr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {
	
	@RequestMapping(value="/list")
	public String queryProductBySolr(){
		
		
		return "product_list";
	}
	
}
