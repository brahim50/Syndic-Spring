package com.syndic.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.syndic.model.Syndic;
@Repository
@Transactional(readOnly = true)
public interface SynRepo extends JpaRepository<Syndic, Integer> {
	
	Optional<Syndic> findByEmail(String email);

}