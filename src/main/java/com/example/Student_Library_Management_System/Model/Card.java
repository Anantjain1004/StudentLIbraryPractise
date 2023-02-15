package com.example.Student_Library_Management_System.Model;

import com.example.Student_Library_Management_System.Enums.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp//it will automatically stamp the time when the entry is created(real time)
    private Date createdOn;//benefit is that it will also give time, and time is also very advance

   @UpdateTimestamp//sets time when an entry is updated.
   private Date updatedOn;

   @Enumerated(value = EnumType.STRING)//we are telling this to sql to keep it in string
   private CardStatus cardStatus;

   @OneToOne
   @JoinColumn
   private Student studentVariableName;//this  is used in the parent class in mapped by
    //while doing the bidirectional mapping



    //Card is a parent with respect to book
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Book> booksIssued = new ArrayList<>();//because list of books will be connected to a card


    //Connecting of the Card class to the transaction
    //bidirectional mapping
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Transactions> transactionsList = new ArrayList<>();


   //constructor
    public Card() {

    }


    //getters and setters

    public List<Transactions> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(List<Transactions> transactionsList) {
        this.transactionsList = transactionsList;
    }

    public List<Book> getBooksIssued() {
        return booksIssued;
    }

    public void setBooksIssued(List<Book> booksIssued) {
        this.booksIssued = booksIssued;
    }

    public Student getStudentVariableName() {
        return studentVariableName;
    }

    public void setStudentVariableName(Student studentVariableName) {
        this.studentVariableName = studentVariableName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }
}

