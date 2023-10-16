package com.example.ExpenseManagementSystem.Repository;

import com.example.ExpenseManagementSystem.Model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Integer> {
}
