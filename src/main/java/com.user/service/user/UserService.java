package com.user.service.user;

import com.user.model.User;

public interface UserService {
    Long createUser (User user) throws Exception;
    void updateUser(User user) throws Exception;
    void deleteUserById(Long id) throws Exception;
    User getUserById(Long id);
    void registerUser(Long id) throws Exception;
}
