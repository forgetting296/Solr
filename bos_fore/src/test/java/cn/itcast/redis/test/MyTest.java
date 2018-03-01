package cn.itcast.redis.test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyTest {
	
	@Autowired
	private RedisTemplate<String, String> rt;
	
	@Test
	public void fun1(){
		//保存key/value    30秒失效
		rt.opsForValue().set("city", "北京", 30, TimeUnit.SECONDS);
		System.out.println(rt.opsForValue().get("city"));
	}
	
}
