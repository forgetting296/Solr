package cn.itcast.mq.listener;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.stereotype.Component;

import cn.itcast.bos.utils.MailUtils;

@Component("sendMailListener")
public class SendMailListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		
		MapMessage mm = (MapMessage) message;
		try {
			String title = mm.getString("title");
			String content = mm.getString("content");
			String to = mm.getString("to");
			MailUtils.sendMail(title, content, to);
		} catch (JMSException e) {
			
			e.printStackTrace();
		}
		
	}

}
