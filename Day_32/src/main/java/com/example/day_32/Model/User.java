package com.example.day_32.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Size(min = 4)
    @Column(columnDefinition = "varchar(25) not null unique")
    private String username;
    @NotEmpty
    @Column(columnDefinition = "varchar(15) not null")
    private String password;
    @NotEmpty
    @Size(min = 4)
    @Column(columnDefinition = "varchar(25) not null")
    private String name;
    @NotEmpty
    @Email
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;
    @NotEmpty
    @Pattern(regexp = "^(USER|ADMIN)$")
    @Column(columnDefinition = "varchar(6) not null")  //check
    private String role;
    @NotEmpty
    @Positive
    @Column(columnDefinition = "int not null")
    private int age;



















}
