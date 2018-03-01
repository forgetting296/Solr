package cn.itcast.mq.listener;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.stereotype.Service;

import com.aliyuncs.exceptions.ClientException;

import cn.itcast.bos.utils.SmsUtils;

/*
 * ******亢宏杰********
 * 监听
 * 	给手机发送验证码
 */
@Service("sendPhoneLister")
public class SendPhoneLister implements MessageListener{

	@Override
	public void onMessage(Message message) {
		MapMessage mapMessage = (MapMessage) message;
		try {
			String telephone = mapMessage.getString("telephone");
			String checkCode = mapMessage.getString("checkCode");
			SmsUtils.sendSms(telephone,checkCode);
			System.out.println(telephone+"    "+checkCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
