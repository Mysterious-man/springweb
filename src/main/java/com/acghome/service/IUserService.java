package com.acghome.service;


import com.acghome.entity.db1.User;

public interface IUserService extends BaseService<User> {

  /*  int addUser(User user);

    User getUserById(int id);*/

    //    通过用户名获得用户对象
    User getUser (String userName);

}
