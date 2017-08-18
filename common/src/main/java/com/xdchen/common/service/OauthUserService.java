package com.xdchen.common.service;

import com.xdchen.common.model.Oauth2User;

import java.util.List;

public interface OauthUserService {
    /**
     * 创建用户
     * @param user
     */
    Oauth2User createUser(Oauth2User user);

    Oauth2User updateUser(Oauth2User user);

    void deleteUser(Long userId);

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    void changePassword(Long userId, String newPassword);

    Oauth2User findOne(Long userId);

    List<Oauth2User> findAll();

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    Oauth2User findByUsername(String username);

}