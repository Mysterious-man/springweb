package com.acghome.service;


import com.acghome.entity.db1.User;

public interface IUserService {

    int addUser(User user);

    User getUserById(int id);

}
