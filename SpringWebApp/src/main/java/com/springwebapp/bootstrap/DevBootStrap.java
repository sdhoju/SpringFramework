package com.springwebapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.springwebapp.model.Author;
import com.springwebapp.model.Book;
import com.springwebapp.repositories.AuthorRepository;
import com.springwebapp.repositories.BookRepository;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private AuthorRepository authorrepo;
	private BookRepository bookrepo;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initValue();
	}
	
	public DevBootStrap(AuthorRepository authorrepo, BookRepository bookrepo) {
		this.authorrepo = authorrepo;
		this.bookrepo = bookrepo;
	}

	public void initValue() {
		//how to win friends and influence people
				Author dale = new Author("Dale", "Carnegie");
				Book htwfaip = new Book(  "How to win friends and influence people",  "123456","Gallery Books");
				dale.getBooks().add(htwfaip);
				htwfaip.getAuthors().add(dale);
				
				authorrepo.save(dale);
				bookrepo.save(htwfaip);
				
				//Avenues
				Author alf = new Author("Alfredo", "Schifini");
				Book ave = new Book("Avenues", "46789", "Hampton Brown");
				alf.getBooks().add(ave);
				ave.getAuthors().add(alf);
				
				authorrepo.save(alf);
				bookrepo.save(ave);
	}

	
}
