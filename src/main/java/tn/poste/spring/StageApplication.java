package tn.poste.spring;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableAspectJAutoProxy
@EnableWebMvc
@EnableScheduling
@SpringBootApplication
public class StageApplication {
	 
	public static void main(String[] args)  {
		SpringApplication.run(StageApplication.class, args);	}

}