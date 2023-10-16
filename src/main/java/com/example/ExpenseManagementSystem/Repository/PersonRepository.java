package com.example.ExpenseManagementSystem.Repository;

import com.example.ExpenseManagementSystem.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Integer> {

}
