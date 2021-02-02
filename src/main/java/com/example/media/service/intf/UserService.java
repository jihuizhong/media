package com.example.media.service.intf;

import com.example.media.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author JiHuizhong
 * @since 2020-12-11
 */
public interface UserService extends IService<User> {

    /**
     * 获取所有用户
     */
    List<User> getUserList();
}
