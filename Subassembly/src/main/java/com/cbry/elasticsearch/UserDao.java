package com.cbry.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserDao extends ElasticsearchRepository<UserBean, String> {

}
