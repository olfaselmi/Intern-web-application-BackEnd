package tn.poste.spring.service;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.bytebuddy.utility.RandomString;
import tn.poste.spring.entity.User;

@Component
public class JwtUtils {
	
	
	
	

	public String generateJwt(User user) {
		RandomString secret = new RandomString();
		Claims claims = Jwts.claims().setIssuer(Long.toString(user.getId()));
		/*claims.put("id",user.getIdUser());
		claims.put("name",user.getNom());
		claims.put("type",user.getBadge());*/
		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret.toString()).compact();
		
	}
	

}
