package tn.poste.spring.mail;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


@Configuration
public class MailConfiguration {

 @Bean
  JavaMailSender mailSender(){
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost("imap.tnpost.tn");
    mailSender.setPort(993);
    mailSender.setUsername("wajdi.said@tnpost.tn");
    mailSender.setPassword("WAJ2478b");

    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.imap.auth", "true");
    props.put("mail.imap.starttls.enable", "true");
    props.put("mail.debug", "true");
    return mailSender;
  }
  
}
