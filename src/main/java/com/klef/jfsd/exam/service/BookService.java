package com.klef.jfsd.exam.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.exam.model.Book;
import com.klef.jfsd.exam.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository br;
	
	public String updateBook(Book b)
	{	
		Optional<Book> book = br.findById(b.getId());
		
		if(book.isPresent())
		{
			Book updatedBook = book.get();
			updatedBook.setAuthor(b.getAuthor());
			updatedBook.setGenre(b.getGenre());
			updatedBook.setPrice(b.getPrice());
			updatedBook.setTitle(b.getTitle());
			updatedBook.setYear(b.getYear());
			
			br.save(updatedBook);
			return "Update SuccessFully";
		}
		return "No such id";
	}
}
