package com.syndic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.syndic.model.Lmmeuble;

@Repository
@Transactional(readOnly = true)
public interface LmmeubleRepository  extends JpaRepository<Lmmeuble, Integer>{

}
