package com.springboot.service;

import com.springboot.dao.SpringBootDao;
import com.springboot.entity.SpringBootEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by shaowei on 2017/3/22.
 */
@Service
public class SpringBootService {

    @Autowired
    private SpringBootDao springBootDao;


    public SpringBootEntity selectSpringBootEntity(String name){
        return springBootDao.findByName(name);
    }

    //事务处理。isolation设置隔离级别，propagation设置传播行为
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    public SpringBootEntity insertSpringBootEntity(SpringBootEntity springBootEntity){
        springBootDao.insert(springBootEntity);


        return springBootEntity;
    }
}
