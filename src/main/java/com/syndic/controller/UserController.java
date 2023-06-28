package com.syndic.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.syndic.model.Syndic;
import com.syndic.repository.SyndicRepository;
import com.syndic.service.SyndicService;

import antlr.collections.List;

import javax.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private SyndicService syndicService;

	@Autowired
	private SyndicRepository repo;

	@Autowired
	private BCryptPasswordEncoder bp;

	// public static String
	// uploadDirectory=System.getProperty("user.dir")+"/src/main/webapp/resources";

	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/profile")
	public String profile(Principal principal,HttpSession session,Model model) {
		session.setAttribute("email",  principal.getName());
		model.addAttribute("syndics", repo.findAll());
		model.addAttribute("syndics", new Syndic());
		//session.setAttribute("email",  principal.getFi);
		return "assets/profile";

	}

	@GetMapping("/dashboard")
	public String dash(Syndic syndic,HttpSession session) {
		String name = syndic.getNom();
		session.setAttribute("name", repo.findByNom(name));
		return "assets/dash";

	}
	

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

	@GetMapping("/SingUp")
	public String register(final Model model) {
		model.addAttribute("syndic", new Syndic());
		// model.addAttribute("userData", new UserData());
		return "register";
	}

	@PostMapping("/sing")
	public String processRegistration(HttpSession session, @RequestParam("file") MultipartFile file, Syndic user,
			final BindingResult bindingResult, final Model model, final @Valid Syndic syndic,
			@RequestParam("nom") String nom, @RequestParam("prenom") String prenom, @RequestParam("email") String email,
			@RequestParam("ville") String ville, @RequestParam("tele") String tele,
			@RequestParam("password") String password

	)

	{

		if (syndicService.exists(email) == true) {

			session.setAttribute("msgError", "EMAIL ALREADY EXIST !!");
			return "register";
		}

		syndicService.saveSyndicToDB(file, nom, prenom, email, tele, ville, bp.encode(password));

		session.setAttribute("message", "You have Create Account Successfuly...");
		return "redirect:/login";

	}

}
