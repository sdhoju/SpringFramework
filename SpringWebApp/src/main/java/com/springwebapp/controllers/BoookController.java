package com.springwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springwebapp.repositories.BookRepository;

@Controller
public class BoookController {
	private BookRepository bookrepo;
	
	

	public BoookController(BookRepository bookrepo) {
		this.bookrepo = bookrepo;
	}



	@RequestMapping("/books")
	private String getBooks(Model model) {
		model.addAttribute("books", bookrepo.findAll());
		return "books";
	}

}
