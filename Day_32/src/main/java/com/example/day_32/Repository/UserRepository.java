package com.example.day_32.Repository;

import com.example.day_32.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(Integer id);
    User findUserByUsernameAndPassword(String username, String password);
    @Query("select u from User u where u.email = ?1")
    User getBYEmail(String email);
    List<User> findUsersByRole(String role);
    @Query("select u from User u where u.age >= ?1")
    List<User> getByAge(int age);



}
