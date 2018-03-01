package bos_management_web;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.dao.StandardDao;
import cn.itcast.bos.domain.Standard;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDataJpaTest {
	
	@Autowired
	private StandardDao standardDao;
	
	@Test
	public void test1(){
		Standard s = new Standard();
		//s.setId(2);
		s.setName("666");
		//System.out.println(s);
		standardDao.save(s);
	}
	
	@Test
	public void test4(){
		Standard s = standardDao.findOne(1);
		System.out.println(s);
	}
	
	@Test
	@Transactional
	public void test6(){
		
		standardDao.abc( "刀剑剑非刀",1);
	}
	
	@Test
	@Transactional
	public void fun8(){
		standardDao.bcd(1, "迷你快件");
		//standardDao.save(standardDao.findOne(1));
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void test7(){
		standardDao.cde("迷你快件",1);
	}
	
	@Test
	public void test8(){
		List<Standard> list = standardDao.def();
		System.out.println(list);
	}
	
	@Test
	public void test2(){
		List<Standard> list = standardDao.findAll();
		System.out.println(list);
	}
	@Test
	@Transactional
	public void test(){
		Standard one = standardDao.getOne(1);
		System.out.println(one);
	}
	
	@Test
	public void test3(){
		List<Standard> list = standardDao.findByNameLike("%1%");
		System.out.println(list);
	}
	@Test
	public void test9(){
		Standard s = standardDao.findOne(1);
		s.setName("刀剑");
		standardDao.save(s);
		//save方法在框架内部调用的是saveOrUpdate方法   先去查询  打印一条select语句   如果查不到  会执行update方法
	}
}
