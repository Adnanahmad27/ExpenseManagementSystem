package com.example.ExpenseManagementSystem.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personId;
    private String name;
    private String contactNo;
    private String gender;
    private Integer age;
    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    private List<Expense> expenseList = new ArrayList<>();

}
