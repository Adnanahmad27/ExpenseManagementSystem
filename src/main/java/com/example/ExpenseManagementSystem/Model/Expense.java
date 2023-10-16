package com.example.ExpenseManagementSystem.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="expense")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer expenseId;
    @Enumerated(value = EnumType.STRING)
    private ExpenseType expenseType;
    private Double amount;
    @ManyToOne
    @JoinColumn
    private Person person;

}
