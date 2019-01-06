package com.springwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springwebapp.repositories.AuthorRepository;

@Controller
public class AuthorController {
	private AuthorRepository authorrepo;

	public AuthorController(AuthorRepository authorrepo) {
		this.authorrepo = authorrepo;
	}
	
	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		
		model.addAttribute("authors", authorrepo.findAll()) ;
		return "authors";
	}
	

}
