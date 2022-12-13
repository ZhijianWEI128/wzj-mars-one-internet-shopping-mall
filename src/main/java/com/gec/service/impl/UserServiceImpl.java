package com.gec.service.impl;

import com.gec.mapper.UserMapper;
import com.gec.pojo.User;
import com.gec.pojo.UserExample;
import com.gec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 业务层实现类
 */
@Service //表示是一个业务层的组件 告诉spring帮我们创建对象  控制反转 IOC
public class UserServiceImpl implements UserService {

    @Autowired  //注入spring框架创建的对象   依赖注入 DI
    UserMapper userMapper;

    @Override //重写
    public User findUserByUserNameAndPassword(User user) {
        //调用mapper的方法
        UserExample userExample = new UserExample();//UserExample 封装了条件查询
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andLoginNameEqualTo(user.getLoginName());// 登录名的条件
        criteria.andPasswordEqualTo(user.getPassword());//密码的条件
        List<User> users = userMapper.selectByExample(userExample);
        return users.size()>0 ? users.get(0): null;
    }

    @Override
    public User finaUserByUserName(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andLoginNameEqualTo(user.getLoginName());
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size()>0){
            return users.get(0);
        }
        user.setEmail(user.getLoginName());
        user.setName("用户");
        user.setRole(1);
        user.setCreateDate(new Date(System.currentTimeMillis()));
        user.setDisabled(false);
        userMapper.insert(user);
        user.setLoginName(null);//controller做铺垫，判断是否重复
        user.setId(userMapper.selectByExample(userExample).get(0).getId());
        return user;
    }
}
