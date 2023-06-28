package com.syndic.service;
import java.io.IOException;

import java.util.Arrays;
import java.util.Base64;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import com.syndic.config.SyndicDetails;
import com.syndic.model.Role;
import com.syndic.model.Syndic;

import com.syndic.repository.SyndicRepository;


@Service
public class SyndicService  implements SynService{

	@Autowired
	private SyndicRepository repo;
	

	
	
	
	public  SyndicService(SyndicRepository repo) {
		super();
		this.repo = repo;
	}

	public void saveSyndicToDB(MultipartFile file, String nom, String prenom, String email, String tele, String vile,
			String password) {
		Syndic s = new Syndic();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a a valid file");
		}
		try {
			s.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		s.setNom(nom);
		s.setPrenom(prenom);
		s.setEmail(email);
		s.setTele(tele);
		s.setVille(vile);
		s.setPassword(password);
		s.setRoles(Arrays.asList(new Role("ROLE_USER")));
		repo.save(s);
	}

	public Syndic findByEmail(String email) {
		return repo.findByEmail(email);
	}

	public boolean exists(String email) {
		return repo.existsByEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Syndic syndic = repo.findByEmail(username);
		
		if(syndic == null) {
			throw new UsernameNotFoundException("Invalid Username Or Password");
		}
		
		else {
			return new SyndicDetails(syndic);
		}
		
		
		//return new org.springframework.security.core.userdetails.User(syndic.getEmail(),syndic.getPassword(),null);
	}
	
	

	

}
