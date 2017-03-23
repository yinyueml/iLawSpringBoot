package com.springboot.dao;

import com.springboot.entity.SpringBootEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by shaowei on 2017/3/22.
 */
@Mapper
public interface SpringBootDao {

    @Select("select * from spring_boot_test where name=#{name}")
    SpringBootEntity findByName(@Param("name") String name);

    @Insert("insert into spring_boot_test values (#{name},#{group})")
    void insert(SpringBootEntity springBootEntity);
}
