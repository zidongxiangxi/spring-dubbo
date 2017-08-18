package com.xdchen.server.service;

import com.xdchen.common.model.Oauth2User;
import com.xdchen.common.service.OauthUserService;
import com.xdchen.server.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service("oauthUserService")
public class OauthUserServiceImpl extends BaseService<OauthUserServiceImpl, Oauth2User> implements OauthUserService {
    @Autowired
    private PasswordHelper passwordHelper;

    @Override
    public Oauth2User createUser(Oauth2User user) {
        if (mapper.insertSelective(user) > 0) {
            return user;
        }
        return null;
    }

    @Override
    public Oauth2User updateUser(Oauth2User user) {
        mapper.updateByPrimaryKeySelective(user);
        return user;
    }

    @Override
    public void deleteUser(Long userId) {
        mapper.deleteByPrimaryKey(userId);
    }

    @Override
    public void changePassword(Long userId, String newPassword) {
        Oauth2User user =this.findOne(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        mapper.updateByPrimaryKey(user);
    }

    @Override
    public Oauth2User findOne(Long userId) {
        return mapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<Oauth2User> findAll() {
        return mapper.selectAll();
    }

    @Override
    public Oauth2User findByUsername(String username) {
        Example example = new Example(Oauth2User.class);
        example.createCriteria().andEqualTo("username", username);
        List<Oauth2User> users = mapper.selectByExample(example);
        return users.isEmpty() ? null : users.get(0);
    }
}
