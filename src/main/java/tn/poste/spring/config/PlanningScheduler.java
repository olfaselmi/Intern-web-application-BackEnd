package tn.poste.spring.config;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import lombok.extern.slf4j.Slf4j;



@Component
@Slf4j
public class PlanningScheduler {
	
	@Autowired
	JavaMailSender mailSender;

	  //  @Transactional
		//@Scheduled(cron="*/15 * * * * *")
	    /*   
		  public void cancelEvent()
		   { Date today= new Date();
		    java.sql.Date sqlDate = new java.sql.Date(today.getTime()+ (1000 * 60 * 60 * 24));
		    Event event= er.getEventToCancel(sqlDate);
		    es.sendCancellingEmail(event);
		   }*/
}
