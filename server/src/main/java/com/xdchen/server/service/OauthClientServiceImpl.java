package com.xdchen.server.service;

import com.xdchen.common.model.Oauth2Client;
import com.xdchen.common.service.OauthClientService;
import com.xdchen.server.common.service.BaseService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service("oauthClientService")
public class OauthClientServiceImpl extends BaseService<OauthClientServiceImpl, Oauth2Client> implements OauthClientService {

    @Override
    public Oauth2Client createClient(Oauth2Client client) {
        if (mapper.insert(client) > 0) {
            return client;
        }
        return null;
    }

    @Override
    public Oauth2Client updateClient(Oauth2Client client) {
        mapper.updateByPrimaryKey(client);
        return client;
    }

    @Override
    public void deleteClient(Long clientId) {
        mapper.deleteByPrimaryKey(clientId);
    }

    @Override
    public Oauth2Client findOne(Long clientId) {
        return mapper.selectByPrimaryKey(clientId);
    }

    @Override
    public List<Oauth2Client> findAll() {
        return mapper.selectAll();
    }

    @Override
    public Oauth2Client findByClientId(String clientId) {
        Example example = new Example(Oauth2Client.class);
        example.createCriteria().andEqualTo("clientId", clientId);
        List<Oauth2Client> clients = mapper.selectByExample(example);
        return clients.isEmpty() ? null : clients.get(0);
    }

    @Override
    public Oauth2Client findByClientSecret(String clientSecret) {
        Example example = new Example(Oauth2Client.class);
        example.createCriteria().andEqualTo("clientSecret", clientSecret);
        List<Oauth2Client> clients = mapper.selectByExample(example);
        return clients.isEmpty() ? null : clients.get(0);
    }
}
