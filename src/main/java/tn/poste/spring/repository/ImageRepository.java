package tn.poste.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.poste.spring.entity.Image;




public interface ImageRepository extends JpaRepository<Image, Long> {
	Optional<Image> findByName(String name);
}
