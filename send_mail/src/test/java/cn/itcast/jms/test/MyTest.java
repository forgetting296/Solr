package cn.itcast.jms.test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
public class MyTest {
	
	@Test
	//P2P的生产者
	public void fun1(){
		//创建connectFactory连接工厂
		ConnectionFactory factory = new ActiveMQConnectionFactory();
		//创建conn连接对象
		try {
			Connection connection = factory.createConnection();
			connection.start();
			//获取session、对象
			//两个参数 
			//参数一：boolean值  是否自动管理事务=》false自动提交事务  
			//参数二：自动提交事务必须配置Session.AUTO_ACKNOWLEDGE
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			//获取Queue   参数是目标名字
			Queue queue = session.createQueue("my.queue");
			//创建生产者
			MessageProducer producer = session.createProducer(queue);
			//创建消息
			TextMessage message = session.createTextMessage("这是一条文本消息");
			//发送消息
			producer.send(message);
		} catch (JMSException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	//P2P消费者
	public void fun2(){
		//创建ConnectionFactory
		ConnectionFactory factory = new ActiveMQConnectionFactory();
		//获取连接对象
		try {
			Connection connection = factory.createConnection();
			connection.start();
			//获取session对象
			//两个参数  配置是否自动管理事务、提交事务
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			//获取目标queue
			Queue queue = session.createQueue("my.queue");
			//创建消费者
			MessageConsumer consumer = session.createConsumer(queue);
			//接收消息（强转）
			TextMessage message = (TextMessage) consumer.receive();
			//打印消息
			System.out.println(message);
			System.out.println(message.getText());
		} catch (JMSException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	//pub/sub消费者
	public void fun3(){
		//创建ConnectionFactory
		ConnectionFactory factory = new ActiveMQConnectionFactory();
		//获取连接对象
		try {
			Connection connection = factory.createConnection();
			connection.start();
			//获取session对象
			//两个参数  配置是否自动管理事务、提交事务
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			//获取目标topic
			Topic topic = session.createTopic("my.topic");
			//创建消费者
			MessageConsumer consumer = session.createConsumer(topic);
			//接收消息（强转）
			consumer.setMessageListener(new MessageListener() {
				
				@Override
				public void onMessage(Message message) {
					//打印消息
					TextMessage Tmessage = (TextMessage) message;
					try {
						System.out.println(Tmessage.getText());
					} catch (JMSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			while(true){
				
			}
		} catch (JMSException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void fun4(){
		//创建connectFactory连接工厂
		ConnectionFactory factory = new ActiveMQConnectionFactory();
		//创建conn连接对象
		try {
			Connection connection = factory.createConnection();
			connection.start();
			//获取session、对象
			//两个参数 
			//参数一：boolean值  是否自动管理事务=》false自动提交事务  
			//参数二：自动提交事务必须配置Session.AUTO_ACKNOWLEDGE
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			//获取Queue   参数是目标名字
			Topic topic = session.createTopic("my.topic");
			//创建生产者
			MessageProducer producer = session.createProducer(topic);
			//创建消息
			TextMessage message = session.createTextMessage("这是一条文本消息");
			//发送消息
			producer.send(message);
		} catch (JMSException e) {
			
			e.printStackTrace();
		}
	}
}
