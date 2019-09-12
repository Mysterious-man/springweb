package com.acghome.mapper.db1;

import com.acghome.entity.db1.User;
public interface UserMapper extends BaseMapper<User> {
    //    通过用户名获得用户对象
    User getUser (String userName);
}