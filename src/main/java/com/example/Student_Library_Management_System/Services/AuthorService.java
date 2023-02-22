package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.DTOs.AuthorEntryDto;
import com.example.Student_Library_Management_System.DTOs.AuthorResponseDto;
import com.example.Student_Library_Management_System.DTOs.BookResponseDto;
import com.example.Student_Library_Management_System.Model.Author;
import com.example.Student_Library_Management_System.Model.Book;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public String createAuthor(AuthorEntryDto authorEntryDto){


        //Important step: In the params, the object is of type dto
        //but the repository interact with only entities or class

        //Solution: Convert authordto to Author class
        Author author = new Author();
        author.setName(authorEntryDto.getName());
        author.setAge(authorEntryDto.getAge());
        author.setCountry(authorEntryDto.getCountry());
        author.setRating(authorEntryDto.getRating());

        authorRepository.save(author);
        return "Author added successfully";
    }

    public AuthorResponseDto getAuthor(Integer authorId){
        Author author =  authorRepository.findById(authorId).get();
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        //Set its attributes
        //need to convert list<book> ---> to-->> list<bookresponsedto>
        List<Book> listOfBooks = author.getBooksWritten();
        List<BookResponseDto> booksWrittenDto = new ArrayList<>();

        for(Book b: listOfBooks){
            BookResponseDto bookResponseDto = new BookResponseDto();
            bookResponseDto.setGenre(b.getGenre());
            bookResponseDto.setPages(b.getPages());
            bookResponseDto.setName(b.getName());

            booksWrittenDto.add(bookResponseDto);
        }

        //Set attributes for author Response Dto
        authorResponseDto.setBooksWritten(booksWrittenDto);
        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());
        authorResponseDto.setCountry(author.getCountry());
        authorResponseDto.setRating(author.getRating());
        return authorResponseDto;
    }

}
