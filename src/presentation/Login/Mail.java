package presentation.Login;

import javax.mail.*;
import javax.mail.internet.*;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

public class Mail {

    protected static final String SMTP_HOST_NAME = "smtp.gmail.com";
    protected static final int SMTP_HOST_PORT = 465;

    public void sendMail(String From, String FromPwd, String To, String subject, String msg) throws Exception {
        Properties props = new Properties();

        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", SMTP_HOST_NAME);
        props.put("mail.smtps.auth", "true");
        // props.put("mail.smtps.quitwait", "false");

        Session mailSession = Session.getDefaultInstance(props);
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject(subject);
        message.setText(msg);

        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(To));
        message.setReplyTo(null);

        transport.connect(SMTP_HOST_NAME, SMTP_HOST_PORT, From, FromPwd);

        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();
    }
    
    
    public void attachFile(String filename, Multipart multipart, MimeBodyPart messageBodyPart) throws MessagingException {
         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         multipart.addBodyPart(messageBodyPart);  
}
     public boolean sendmailattach(String from,String password,String to,String subject,String body,String[] attachFiles,int index) {    
     

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(body);

                        // Create the message part
         BodyPart messageBodyPart = new MimeBodyPart();

         // Now set the actual message
         messageBodyPart.setText(body);

         // Create a multipar message
         Multipart multipart = new MimeMultipart();

         // Set text message part
         multipart.addBodyPart(messageBodyPart);

         
         
         messageBodyPart = new MimeBodyPart();
if (index> 0) {
    //attach file
   
    attachFile(attachFiles[0], multipart, (MimeBodyPart) messageBodyPart);
    if (index > 1) {
        for (int indexs = 1; indexs < index; indexs++) {
            attachFile(attachFiles[indexs], multipart, new MimeBodyPart());
        }
    }
}
         
         // Send the complete message parts
         message.setContent(multipart);
                        
                        
                        
                        
                        
			Transport.send(message);

			return true;

		} catch (MessagingException e) {
			return false;
		}
   }
}
