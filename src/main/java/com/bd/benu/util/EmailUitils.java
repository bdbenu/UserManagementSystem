/**
 *benudharmunda
 * 31-Aug-2024
 *
 */
package com.bd.benu.util;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.bd.benu.model.UsersMaster;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

/**
 * benudharmunda 31-Aug-2024
 */
@Component
public class EmailUitils {

//	@Autowired
	// private UsersMaster master;

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String to, String subject, String text)
			throws MessagingException {

		System.out.println("sendEmail method start");

		MimeMessage message = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		//String passwordval = master.getPassword();
		String resetUrl = "http://localhost:9090/reset-password";
		String content = "<p>Hello,</p>"
				+"Your Password "+text
				+ "<p>You have requested to reset your password. Click the link below to reset it:</p>"
				+ "<p><a href=\"" + resetUrl + "\">Reset Password</a></p>" + "<br>"
				+ "<p>Ignore this email if you did not request a password change.</p>"+text;

		System.out.println("Sending email:");
		System.out.println("To: " + to);
		System.out.println("Subject: " + subject);
		System.out.println("Text: " + text);
		String textVal = "Password is";

		helper.setTo(to);
		helper.setFrom("bdbenu18@gmail.com"); // sender's email
		helper.setTo(to); // recipient's email
		helper.setText("test");
		helper.setSubject("Password");

		helper.setText(content, true);

		javaMailSender.send(message);

		System.out.println("sendEmail method end");

	}

}
