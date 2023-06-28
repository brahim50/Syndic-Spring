package com.syndic.controller;



import javax.servlet.http.HttpSession;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.json.simple.JSONObject;

import com.syndic.model.Lmmeuble;
import com.syndic.model.Syndic;
import com.syndic.repository.LmmeubleRepository;

import com.syndic.repository.SyndicRepository;

@Controller
public class LmmeubleController {

	

	
	
	@Autowired
	private LmmeubleRepository lmmeubleRepository;
	
	@Autowired
	private SyndicRepository syndicRepository;
	

	@GetMapping("/lmmeuble/{id}")
	public String lmmeuble(Model model,HttpSession session) {
		model.addAttribute("lmmeuble", new Lmmeuble());
		Syndic syndic = new Syndic();
		session.setAttribute("id", syndicRepository.findById(syndic.getId()));
		
		return "/lmmeuble";
	}
	
	@PostMapping("/add")
	public @ResponseBody String addLmmeuble(Lmmeuble lmmeuble, Syndic syndic) {
		 lmmeubleRepository.save(lmmeuble);
		JSONObject resObj = new JSONObject();
		resObj.put("syndic",lmmeuble.getNbretage());
		resObj.put("nom", lmmeuble.getNom());
		resObj.put("address", lmmeuble.getAddress());
		resObj.put("numero", lmmeuble.getNumero());
		resObj.put("nbretage", lmmeuble.getNbretage());
		resObj.put("ville", lmmeuble.getVille());
		
		
		return resObj.toString();
	}
	
	@GetMapping("/lmmeubles")
	public @ResponseBody List<Lmmeuble> fetchAllMeuble(){
		List<Lmmeuble> lmmeubles = lmmeubleRepository.findAll();
		return lmmeubles;
	}
	
	
	
	
	
	
	
	
	
	

}
