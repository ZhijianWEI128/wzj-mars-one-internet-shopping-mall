package com.gec.service;

import com.gec.pojo.User;
import org.springframework.stereotype.Service;

/**
 * 业务层接口
 */
@Service
public interface UserService {
    User findUserByUserNameAndPassword(User user);
    User finaUserByUserName(User user);
}
