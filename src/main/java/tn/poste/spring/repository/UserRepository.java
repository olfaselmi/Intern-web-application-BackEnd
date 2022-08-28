package tn.poste.spring.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.poste.spring.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//	@Query("select u from user u where u.email=?1")
	//@Transactional
	@Query(value="select * from user where email=?1 ", nativeQuery = true)
	public Optional<User>findUserByEmail(String email);


//	@Query("select u from user u where u.domain=?1")
	//@Transactional

	@Query(value="select * from user  where domain=?1", nativeQuery = true)
	public List<User> filterByDomain(String domain);

	//@Query("select u from user u order by name")
	//@Transactional
	@Query(value="select * from user order by name", nativeQuery = true)
	public List<User> orderByName();

	//@Query("select u from user u where u.email=?1 and u.password=?2")
	//@Transactional
	@Query(value="select * from user where email=?1 and password=?2", nativeQuery = true)
	public Optional<User> authenticate(String email, String password);
	

}
