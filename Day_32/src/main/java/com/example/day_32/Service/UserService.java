package com.example.day_32.Service;


import com.example.day_32.Api.ApiException;
import com.example.day_32.Model.User;
import com.example.day_32.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Integer id,User user) {
        User u = userRepository.findUserById(user.getId());
        if (u == null) {
            throw new ApiException("User not found");
        }
        u.setName(user.getName());
        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setAge(user.getAge());
        u.setRole(user.getRole());
        userRepository.save(u);
    }

    public void deleteUser(Integer id) {
        User u = userRepository.findUserById(id);
        if (u == null) {
            throw new ApiException("User not found");
        }
        userRepository.delete(u);
    }

    public User check(String username , String password){
        User u = userRepository.findUserByUsernameAndPassword(username,password);
        if (u == null){
            throw new ApiException("User not found");
        }
        return u;
    }

    public User getByEmail(String email) {
        User u = userRepository.getBYEmail(email);
        if (u == null){
            throw new ApiException("User not found");
        }
        return u;
    }

    public List<User> getByRole(String role) {
        List<User> users = userRepository.findUsersByRole(role);
        if (users == null){
            throw new ApiException("There is no User with the given role");
        }
        return users;
    }

    public List<User> getByAge(int age) {
        List<User> users = userRepository.getByAge(age);
        if (users == null) {
            throw new ApiException("There is no User with or above the given age");
        }
        return users;
    }





















}
