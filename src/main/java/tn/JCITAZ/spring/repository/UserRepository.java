package tn.JCITAZ.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.JCITAZ.spring.entities.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long>{
	
	Optional<AppUser> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

}
