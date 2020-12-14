package com.example.wbdvsp20finalprojectserver.repositories;
import com.example.wbdvsp20finalprojectserver.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository
    extends CrudRepository<User, Integer> {

    @Query("SELECT user FROM User user")
    public List<User> findAllUsers();

    @Query("SELECT user FROM User user WHERE user.id=:uid")
    public User findUserById(
            @Param("uid") Integer uid);

    @Query("SELECT user FROM User user WHERE user.email=:email")
    public User findUserByEmail(
            @Param("email") String email);

    @Query("SELECT user FROM User user WHERE user.email=:email AND user.password=:password")
    public User findUserByCredentials(
            @Param("email") String email,
            @Param("password") String password);
}
