package com.claimTransfer.config;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import java.util.Properties;

/**
 * 
 */
public class SendingMail {

	public void run(String subject, String body,String companyId) throws Exception {
		System.out.println(companyId);
		System.out.println("MessageBody -------------> " + body);
		Message message = new MimeMessage(getSession());
		String recipients = Utility.getPropStringValues("mail.to"+"."+companyId);
		String[] list = recipients.split(",");
		message.addFrom(new InternetAddress[] { new InternetAddress(Utility.getPropStringValues("mail.from"+"."+companyId)) });

		if (list != null) {
			for (String address : list) {
				message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(address));
			}
		}

		message.addRecipient(RecipientType.BCC, new InternetAddress(Utility.getPropStringValues("mail.from"+"."+companyId)));

		message.setSubject(subject + " " + Utility.getPropStringValues("mail.subject"));

		message.setContent(body, "text/plain");
		try {
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	private Session getSession() {

		Properties properties = new Properties();
		properties.setProperty("mail.smtp.host", Utility.getPropStringValues("mail.smtp.host"));
		properties.setProperty("mail.smtp.port", Utility.getPropStringValues("mail.smtp.port"));

		return Session.getInstance(properties, null);
	}

}
