package com.springboot.response;

import com.springboot.entity.SpringBootEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shaowei on 2017/3/22.
 */
public class SpringbootResponse extends ResultResponse {
    private List<SpringBootEntity> data = new ArrayList<SpringBootEntity>();

    public List<SpringBootEntity> getData() {
        return data;
    }

    public void setData(List<SpringBootEntity> data) {
        this.data = data;
    }
}
