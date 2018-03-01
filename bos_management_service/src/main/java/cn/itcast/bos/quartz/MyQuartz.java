package cn.itcast.bos.quartz;

import java.util.Date;

import org.springframework.stereotype.Service;



@Service("myQuartz")
public class MyQuartz {
	
	public void xxx(){
		
		System.out.println("定时器执行了"+new Date().getTime());
	}
	
}
