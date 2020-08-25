package com.jiangjiawei.service;

import com.jiangjiawei.domain.User;

public interface UserService {

    //判断输入信息是否能找到这个用户
    User login(String name, String password);

}
