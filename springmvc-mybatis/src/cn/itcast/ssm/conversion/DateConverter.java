package cn.itcast.ssm.conversion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String resource) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		try {
			return df.parse(resource);
		} catch (ParseException e) {
			System.out.println("------------------------转换失败------------------------");
			e.printStackTrace();
		}
		return null;
	}
	
}
