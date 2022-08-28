package tn.poste.spring.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.poste.spring.entity.Bureau;


@Repository
public interface BureauRepository extends CrudRepository<Bureau, Long> ,JpaRepository<Bureau, Long> {
	
	
	
	@Query("SELECT DISTINCT u.name as name,COALESCE(COUNT(t),0) as value FROM User u join u.Bureau t GROUP BY u")
	List<Map<Long,Integer>> statistics();
	
	//public List<Bureau>findByPositionGPS(String PositionGPS);
	
	
	
	@Query("SELECT count(u) FROM Bureau u ")	
	int nbBureaux();
}
