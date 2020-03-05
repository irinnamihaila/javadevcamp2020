package com.adobe.devcamp.service;

import com.adobe.devcamp.dao.UserDao;
import com.adobe.devcamp.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserDao userDao;
    private final ObjectMapper objectMapper;

    public UserService(UserDao userDao, ObjectMapper objectMapper) {
        /*dependency injection - am nevoie sa creez in prealabil un userDao pentru a putea cred userService
        nu il creez, se primeste din afara
        creare dependinte prin constructor*/
        this.userDao = userDao;
        this.objectMapper = objectMapper;
    }

    //1.SELECT users from database and convert Map<Integer, String> to Map<Integer, User>
    public Map<Integer, User> selectUsers(){
        Map<Integer, User> users = new HashMap<>();
        final Map<Integer, String> usersAsString = userDao.selectAll();
        for(Map.Entry<Integer, String> entry : usersAsString.entrySet()){
            try {
                final User user = objectMapper.readValue(entry.getValue(), User.class);
                users.put(entry.getKey(), user);
            } catch (JsonProcessingException e) {
               // e.printStackTrace(); don't do that
                logger.error("Object {} can't be deserialized", entry.getValue());
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return users;
    }

}
