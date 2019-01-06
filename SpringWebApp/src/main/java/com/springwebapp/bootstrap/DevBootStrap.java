package com.springwebapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.springwebapp.model.Author;
import com.springwebapp.model.Book;
import com.springwebapp.model.Publisher;
import com.springwebapp.repositories.AuthorRepository;
import com.springwebapp.repositories.BookRepository;
import com.springwebapp.repositories.PublisherRepository;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private AuthorRepository authorrepo;
	private BookRepository bookrepo;
	private PublisherRepository publisherrepo;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initValue();
	}
	
	public DevBootStrap(AuthorRepository authorrepo, BookRepository bookrepo, PublisherRepository publisherrepo) {
		this.authorrepo = authorrepo;
		this.bookrepo = bookrepo;
		this.publisherrepo = publisherrepo;

	}

	public void initValue() {
		//how to win friends and influence people
				Author dale = new Author("Dale", "Carnegie");
				Publisher p1 = new Publisher("Gallery Books","New York");
				Book htwfaip = new Book(  "How to win friends and influence people",  "123456",p1);
				dale.getBooks().add(htwfaip);
				htwfaip.getAuthors().add(dale);
				
				
				authorrepo.save(dale);
				publisherrepo.save(p1);
				bookrepo.save(htwfaip);
				
				//Avenues
				Author alf = new Author("Alfredo", "Schifini");
				Publisher p2 = new Publisher("Hampton Brown","New York");
				Book ave = new Book("Avenues", "46789", p2);
				alf.getBooks().add(ave);
				ave.getAuthors().add(alf);
				
				authorrepo.save(alf);
				publisherrepo.save(p2);
				bookrepo.save(ave);

	}

	
}
