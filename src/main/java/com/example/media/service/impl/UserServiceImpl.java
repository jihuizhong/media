package com.example.media.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.media.entity.User;
import com.example.media.mapper.UserMapper;
import com.example.media.service.intf.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author JiHuizhong
 * @since 2020-12-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        QueryWrapper<User> qw = new QueryWrapper<>();
        Page<User> userPage = new Page<>(1, 10);
        IPage<User> userIPage = userMapper.selectPage(userPage, qw);
        return userMapper.selectList(qw);
    }
}
