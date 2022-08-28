package tn.poste.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import tn.poste.spring.entity.User;



public interface UserService {
	
public List<User> getAllUser();	
User addUser(User u);
void deleteUser(Long id);
User updateUser(User u);
User retrieveUser(Long id);
Optional<User> FindUserByEmail(String email);
List<User> filterByDomain(String domain);
public List<User> orderByName();
public User authenticate(String email, String password);

public void blockUser(Long iduser);
public void unblockUser(Long iduser);

public List<User> topUsers();



User Authenticate(String email,String password);
boolean verifyPassword(String email,String password);
User ResetPassword(String email,String password);
}
