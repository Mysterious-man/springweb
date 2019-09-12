package com.acghome.service;


import com.acghome.mapper.db1.UserMapper;
import com.acghome.entity.db1.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service(value = "userService")
public class UserServiceImpl implements IUserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {

        userMapper.insertSelective(user);


        return 1;
    }

    @Override
    public User getUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    //分页的
//
//    @Override
//    public List<User> getUserPage(int page_id) {
//
//        //5个一页
//        int rows=5;
//        int total=userMapper.countByExample(new UserExample());
//
//        int offset=(page_id-1)*rows;
//        int limit=offset+5;
//
//        if(limit>=total){
//            limit=total-1;
//        }
//
//
//        RowBounds rowBounds = new RowBounds(offset, limit);
//
//        UserExample example=new UserExample();
//
//        return userMapper.selectByExampleWithRowbounds(example,rowBounds);
//    }

}
