package com.Project.GpsTracker.Service;

import com.Project.GpsTracker.DAO.UserDao;
import com.Project.GpsTracker.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public boolean login(String email, String password) {
        try{
            User user = userDao.verify(email,password);
            if(user != null){
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }

    public ResponseEntity<String> addUser(String email, String password) {
        try{
            User user = userDao.verify(email,password);
            if(user != null){
                return new ResponseEntity<>("User already exists", HttpStatus.CONFLICT);
            }
            User u = new User();
            u.setEmail(email);
            u.setPassword(password);
            userDao.save(u);
            return new ResponseEntity<>("User created", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
