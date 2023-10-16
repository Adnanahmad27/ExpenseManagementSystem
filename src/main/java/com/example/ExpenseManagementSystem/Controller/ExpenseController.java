package com.example.ExpenseManagementSystem.Controller;

import com.example.ExpenseManagementSystem.Model.Expense;
import com.example.ExpenseManagementSystem.Service.ExpenseService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;
    @PostMapping("/addExpense")
    public ResponseEntity addExpense(@RequestBody Expense expense , @RequestParam("personId")Integer personId){
        try{
            String result = expenseService.addExpense(expense,personId);
            return new ResponseEntity(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
