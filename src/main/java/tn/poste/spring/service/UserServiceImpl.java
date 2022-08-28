package tn.poste.spring.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tn.poste.spring.entity.User;
import tn.poste.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository ur;

	BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
	
    @Autowired
	public UserServiceImpl(UserRepository ur) {
		this.ur=ur;
	}
	@Override
	public List<User> getAllUser() {
        return (List<User>)ur.findAll();
	}

	@Override
	public User addUser(User u) {
		
		String email= u.getEmail();
		   Optional<User> user= ur.findUserByEmail(email);
		   if (user.isPresent())
		   {
			   System.out.println("user already exists");
		   }
		   else
		   {  
			u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
			u.setBlocked(false);
	        ur.save(u);
		   }
	        return u;
	}

	
	@Override
	public void deleteUser(Long id){
		ur.deleteById(id);
	}

	@Override
	public User updateUser(User u) {
		ur.save(u);
		return u;
	}

	@Override
	public User retrieveUser(Long id) {
		User u=ur.findById(id).get();
		return u;
	}
	 @Override
	    public Optional<User> FindUserByEmail(String email) {
	        return ur.findUserByEmail(email);
	    }
	@Override
	public List<User> filterByDomain(String domain) {
		return ur.filterByDomain(domain);
	}
	@Override
	public List<User> orderByName() {
		return ur.orderByName();
	}
	@Override
	public User authenticate(String email, String password) {
	      Optional<User> u= ur.findUserByEmail(email);
	         if (u.isPresent())
	         {
	             User user= u.get();
	             if (password.equals(user.getPassword())){
	                 return user;
	             }
	         }
	         
             System.out.println("Ooops ! Try again..");

	    return null;
	}
	
	@Override
	public void blockUser(Long iduser) {

		User u= ur.findById(iduser).get();
		u.setBlocked(true);
		ur.save(u);
	}
		

    @Override
    public User Authenticate(String email, String password) {
        Optional<User> UserExists=ur.findUserByEmail(email);
        if(UserExists.isPresent()){
            User user=UserExists.get();
            if (bCryptPasswordEncoder.matches(password,user.getPassword())){
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean verifyPassword(String email, String password) {
        Optional<User> UserExists=ur.findUserByEmail(email);
        if(UserExists.isPresent()){
            User user=UserExists.get();
            return bCryptPasswordEncoder.matches(password, user.getPassword());
        }
        return false;
    }

    @Override
    public User ResetPassword(String email, String password) {
        Optional<User> UserExists=ur.findUserByEmail(email);
        if(UserExists.isPresent()){
            User user=UserExists.get();
            user.setPassword(bCryptPasswordEncoder.encode(password));
            return ur.save(user);
        }
        return null;
    }
	@Override
	public void unblockUser(Long iduser) {
		User u= ur.findById(iduser).get();
		u.setBlocked(false);
		ur.save(u);
		
	}
	@Override
	public List<User> topUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
