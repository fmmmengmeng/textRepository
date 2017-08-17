/**   
 * Copyright © 2017 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * @Package: com.clps.taining.email.domain 
 * @author: Vera   
 * @date: 2017年8月17日 上午8:39:19 
 */
package com.clps.taining.email.domain;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/** 
 * @ClassName: Demo1 
 * @Description: 使用简单方式发送一封邮件(普通文本文件)
 * @author: Vera
 * @date: 2017年8月17日 上午8:39:20  
 */
public class Demo1 {
//		qq
//		   pop.qq.com 995 	smtp.qq.com 465或587
//		163:
//		   imap: imap.163.com 993 143
//		   pop3: pop.163.com 995 110
//		   smtp: smtp.163.com 465/994 25
//		souhu:
//		   pop3.sohu.com    smtp.sohu.com
		
		public static void main(String[] args) throws MessagingException {
			Properties props = new Properties();
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.transport.protocol", "smtp");
			
			Session session = Session.getDefaultInstance(props);
			session.setDebug(true);
			
			// 发件人电子邮箱
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("283654838@qq.com"));
			msg.setText("I love you!");
			msg.setSubject("This is the Subject Line!");
			
			Transport trans = session.getTransport();
			trans.connect("smtp.qq.com",587, "283654838", "uyqyvtxvrszsbicc");
			// 收件人电子邮箱
			trans.sendMessage(msg, new Address[]{new InternetAddress("283654838@qq.com")});
			
			trans.close();
		}

}
