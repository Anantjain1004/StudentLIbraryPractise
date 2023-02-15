package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.DTOs.BookRequestDto;
import com.example.Student_Library_Management_System.Model.Author;
import com.example.Student_Library_Management_System.Model.Book;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import com.example.Student_Library_Management_System.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;

    public String addBook(BookRequestDto bookRequestDto){

        //I want to get the author entity
        int authorId = bookRequestDto.getAuthorId();

        //Now I will be fetching the author entity
        Author author = authorRepository.findById(authorId).get();

        //we have to made it to save it to db
        Book book = new Book();
        //basic attributes are from dto to entity layer
        book.setGenre(bookRequestDto.getGenre());
        book.setIssued(false);
        book.setName(bookRequestDto.getName());
        book.setPages(bookRequestDto.getPages());


        //Basic attribute are already set from postman,settng
//        the foreign att in child class;
        book.setAuthor(author);

        //We need to update the list of books written in the parent class

        List<Book> currentBooksWritten = author.getBooksWritten();
        currentBooksWritten.add(book);
//        author.setBooksWritten(currentBooksWritten);

        //Now the book is to be saved, but also the author is to be saved

        //Why do we need to update the author? bcz the author entity ha been updated
        //we have to resave/update it

        authorRepository.save(author);//bcz data was modified

        //.save works both as save function and update function

        //bookRepo.save is not required because it will be auto called by
        //cascading effect
        return "Book added successfully";


    }
}
