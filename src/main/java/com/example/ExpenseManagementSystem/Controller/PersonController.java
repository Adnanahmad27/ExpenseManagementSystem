package com.example.ExpenseManagementSystem.Controller;

import com.example.ExpenseManagementSystem.Model.Person;
import com.example.ExpenseManagementSystem.Repository.PersonRepository;
import com.example.ExpenseManagementSystem.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/addPerson")
    public ResponseEntity addPerson(@RequestBody Person person){
        try {
            String result = personService.addPerson(person);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findAllPersonNames")
    public List<String> getAllAuthorNames(){
        return personService.getAllPersonNames();
    }

    @GetMapping("/getPerson/{id}")
    public ResponseEntity getAuthor(@PathVariable("id")Integer id){

        try {
            Person person = personService.getPersonById(id);
            return new ResponseEntity(person,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getTotalExpenseAmount")
    public ResponseEntity getTotalExpenseAmount(@RequestParam("authorId")Integer authorId){

        try{
            Double totalAmount= personService.getTotalExpenseAmount(authorId);
            return new ResponseEntity(totalAmount,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
