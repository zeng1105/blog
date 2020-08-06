package com.myhub.service.impl;

import com.myhub.entity.User;
import com.myhub.mapper.UserMapper;
import com.myhub.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zeng1105
 * @since 2020-08-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
