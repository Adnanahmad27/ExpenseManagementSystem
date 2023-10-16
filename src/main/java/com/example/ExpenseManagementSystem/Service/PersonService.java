package com.example.ExpenseManagementSystem.Service;

import com.example.ExpenseManagementSystem.Model.Expense;
import com.example.ExpenseManagementSystem.Model.Person;
import com.example.ExpenseManagementSystem.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    public String addPerson(Person person) throws Exception{

        if(person.getPersonId()!=null){
            throw new Exception("Person Id is already present");
        }
        personRepository.save(person);
        return "Person has been added successfully";
    }

    public Person getPersonById(Integer personId) throws Exception {
        Optional<Person> optionalPerson = personRepository.findById(personId);
        if(!optionalPerson.isPresent()){
            throw new Exception("The Id Entered is invalid");
        }
        return optionalPerson.get();
    }

    public List<String> getAllPersonNames() {
        List<Person> personList = personRepository.findAll();
        List<String> personNames = new ArrayList<>();
        for(Person person : personList){
            personNames.add(person.getName());
        }
        return personNames;
    }

    public Double getTotalExpenseAmount(Integer authorId) throws Exception {
        Person person = getPersonById(authorId);
        Double totalAmount = 0d;
        List<Expense> expenseList = person.getExpenseList();
        for (Expense expense : expenseList){
            totalAmount += expense.getAmount();
        }
        return totalAmount;
    }
}
