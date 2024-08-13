package com.example.day_32.Controller;

import com.example.day_32.Api.ApiResponse;
import com.example.day_32.Model.User;
import com.example.day_32.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUsers() {
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user , Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser( @PathVariable Integer id,@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.updateUser(id,user);
        return ResponseEntity.status(200).body(new ApiResponse("User updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted successfully"));
    }


    @GetMapping("/check/{username},{password}")
    public ResponseEntity checkUser(@PathVariable String username,@PathVariable String password) {
        userService.check(username,password);
        return ResponseEntity.status(200).body(new ApiResponse("User check successfully , Username and password are correct"));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity getByEmail(@PathVariable String email) {
        return ResponseEntity.status(200).body(userService.getByEmail(email));
    }

    @GetMapping("/role/{role}")
    public ResponseEntity getByRole(@PathVariable String role) {
        return ResponseEntity.status(200).body(userService.getByRole(role));
    }

    @GetMapping("/age/{age}")
    public ResponseEntity getByAge(@PathVariable int age) {
        return ResponseEntity.status(200).body(userService.getByAge(age));
    }



















}
