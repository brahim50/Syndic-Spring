package com.syndic.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.syndic.model.Syndic;

@Repository
@Transactional(readOnly = true)
public interface SyndicRepository extends JpaRepository<Syndic, Integer>{
	
	
	//boolean existsByEmail(String email);
	//public Syndic findByEmail(String email);
	boolean existsByEmail(String email);
	Syndic findByEmail(String email);
	Syndic findByNom(String Username);
	
	//public Syndic findByEmail(String email);
       //public boolean isEmailAleardyPresent(String email); 
	Optional<Syndic> findById(Long id);
	//Syndic findByUsername(String username);
	
	
	
	
}
