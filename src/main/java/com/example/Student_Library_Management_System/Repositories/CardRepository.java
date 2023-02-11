package com.example.Student_Library_Management_System.Repositories;

import com.example.Student_Library_Management_System.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {
}
