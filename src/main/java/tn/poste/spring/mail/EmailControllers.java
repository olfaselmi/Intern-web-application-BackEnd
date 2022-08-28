package tn.poste.spring.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EmailControllers {
	
	 @Autowired
		JavaMailSender mailSender;

	  
	  @GetMapping("/test")
		public String send(){
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("wajdi.said@tnpost.tn");
			message.setTo("jemili.hamadi@tnpost.tn");
			message.setSubject("La poste Tunisienne");
			message.setText("Votre demande est en cours.... ");
			mailSender.send(message);
			
			return "done";
		}
	  
	
	  public String ApplicationMail(String Mail , String nomDequipement, String Nom)
	  {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("selmisolfa@gmail.com");
			message.setTo(Mail);
			message.setText("Cher(e) : "+Nom+ "\n votre equipement : " +nomDequipement+ " est envoyé pour reparation !");
			message.setSubject("Reparation d'equipement");
			mailSender.send(message);
		 
		    return "Successfully sent";
	  }
	  
	



}
