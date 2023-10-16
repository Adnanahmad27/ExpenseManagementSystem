package com.example.ExpenseManagementSystem.Service;

import com.example.ExpenseManagementSystem.Model.Expense;
import com.example.ExpenseManagementSystem.Model.Person;
import com.example.ExpenseManagementSystem.Repository.ExpenseRepository;
import com.example.ExpenseManagementSystem.Repository.PersonRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private PersonRepository personRepository;
    public String addExpense(Expense expense , Integer perssonId) throws Exception{
        //Validation
        //AuthorId should be valid
        Optional<Person> optionalPerson = personRepository.findById(perssonId);

        if(!optionalPerson.isPresent()){
            throw new Exception("Author Id Entered is Incorrect");
        }
        Person person = optionalPerson.get();
        expense.setPerson(person);
        person.getExpenseList().add(expense);
        personRepository.save(person);
        return "Expense has been added to the db";

    }
}
