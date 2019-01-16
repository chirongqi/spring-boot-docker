package com.chirq.study.business.dao;

import com.chirq.study.business.entity.User;

import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {

    User selectByName(String name);

    // int insert(User user);
    //
    // int insertSelective(User user);
    //
    // int updateByPrimaryKeySelective(User user);
}
