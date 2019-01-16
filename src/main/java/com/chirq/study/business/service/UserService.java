package com.chirq.study.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chirq.study.business.dao.UserMapper;
import com.chirq.study.business.entity.User;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
import tk.mybatis.mapper.util.StringUtil;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int save(User user) {
        return userMapper.insert(user);
    }

    public int delete(long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    public List<User> selectByName(User user) {
        Example example = new Example(User.class);
        Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(user.getName())) {
            criteria.andLike("name", "%" + user.getName() + "%");
        }
        return userMapper.selectByExample(example);
    }
    
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

}
