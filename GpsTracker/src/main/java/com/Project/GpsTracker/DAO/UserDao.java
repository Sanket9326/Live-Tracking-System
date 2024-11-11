package com.Project.GpsTracker.DAO;

import com.Project.GpsTracker.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

public interface UserDao extends JpaRepository<User, Integer> {

    @Query(value = "Select * FROM User where email = :email AND password = :password",nativeQuery = true)
    User verify(@Param("email") String email,@Param("password") String password);

}
