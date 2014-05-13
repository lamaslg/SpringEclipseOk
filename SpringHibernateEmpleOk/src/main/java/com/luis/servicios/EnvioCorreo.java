package com.luis.servicios;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class EnvioCorreo {

	final static String CORREO="cursomicroforum2014@gmail.com";
	final static String PASS="mecagoentupadre";
	final static String SMTP="smtp.gmail.com";
	final static String PUERTO="587";
	
	
	public static void EnviarCorreo(String destino,String asunto,
			String texto){
		
		Properties props=new Properties();
		props.setProperty("mail.smtp.host", SMTP);
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.port",PUERTO );
		props.setProperty("mail.smtp.user", CORREO);
		props.setProperty("mail.smtp.auth", "true");
		
		
		Session sesion=Session.getDefaultInstance(props);
		
		
		MimeMessage msg=new MimeMessage(sesion);
		try {
			msg.setFrom(new InternetAddress(CORREO));
			msg.addRecipient(Message.RecipientType.TO, 
					new InternetAddress(destino));
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			msg.setSubject(asunto);
			msg.setText(texto);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Transport t=null;
		try {
			t = sesion.getTransport("smtp");
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t.connect(CORREO, PASS);
			t.sendMessage(msg,msg.getRecipients(RecipientType.TO));
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}







