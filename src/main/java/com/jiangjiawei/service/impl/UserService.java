package com.jiangjiawei.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.jiangjiawei.dao.UserMapper;
import com.jiangjiawei.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService implements com.jiangjiawei.service.UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String name, String password) {
        User user = null;
        if(!(ObjectUtil.isEmpty(name) && ObjectUtil.isEmpty(password))){
            Map<String,Object> map = new HashMap<>();
            map.put("name",name);
            map.put("password",password);
            user = userMapper.findUserByCondition(map);
            return user;
        }
        return user;
    }
}
