package com.user.service.user;

import com.user.model.User;
import com.user.repository.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tools.jackson.databind.ObjectMapper;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Long createUser(User user) throws Exception {
        //Object Mapper reference
        String userAsString = objectMapper.writeValueAsString(user);
        System.out.println("Starting create a user : " + userAsString);
        User userFromString = objectMapper.readValue(userAsString, User.class);


        return userRepository.createUser(user);
    }

    @Override
    public void updateUser(User user) throws Exception {
        userRepository.updateUser(user);
    }

    @Override
    public void deleteUserById(Long id) throws Exception {
        userRepository.deleteUserById(id);
    }

   @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void registerUser(Long id) throws Exception {
        userRepository.registerUser(id);
    }
/*
    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
*/
}
