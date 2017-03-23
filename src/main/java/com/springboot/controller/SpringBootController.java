package com.springboot.controller;

import com.springboot.entity.SpringBootEntity;
import com.springboot.response.SpringbootResponse;
import com.springboot.service.SpringBootService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shaowei on 2017/3/21.
 */

@RestController
@RequestMapping("/springBoot")
@Api(value = "springBoot的测试controller")
public class SpringBootController {
    protected Logger logger = Logger.getLogger(this.getClass());

    @Resource
    private SpringBootService springBootService;

    @ApiOperation(value = "get", notes = "get方法获取json", httpMethod = "GET")
    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public
    @ResponseBody
    SpringbootResponse getSpringBoot(@ApiParam(value = "名字") @PathVariable("name") String name) {
        SpringbootResponse springbootResponse = new SpringbootResponse();
        try {
            SpringBootEntity springBootEntity = springBootService.selectSpringBootEntity(name);
            logger.info("get方法成功");
            List<SpringBootEntity> springBootEntityList = new ArrayList<SpringBootEntity>();
            springBootEntityList.add(springBootEntity);

            springbootResponse.setResultCode("1");
            springbootResponse.setResultMessage("成功");
            springbootResponse.setData(springBootEntityList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            springbootResponse.setResultCode("0");
            springbootResponse.setResultMessage("失败");
            springbootResponse.setData(null);
        }


        return springbootResponse;
    }


    @RequestMapping(value="/add",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ApiOperation(value="新增springboot",notes = "新增springboot")
    public
    @ResponseBody
    SpringbootResponse addSpringBoot(@ApiParam(required = true,value = "springBootEntity")@RequestBody SpringBootEntity springBootEntity){
        SpringbootResponse springbootResponse=new SpringbootResponse();
        try {
            springBootService.insertSpringBootEntity(springBootEntity);
            logger.info("get方法成功");
            List<SpringBootEntity> springBootEntityList = new ArrayList<SpringBootEntity>();
            springBootEntityList.add(springBootEntity);

            springbootResponse.setResultCode("1");
            springbootResponse.setResultMessage("成功");
            springbootResponse.setData(springBootEntityList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            springbootResponse.setResultCode("0");
            springbootResponse.setResultMessage("失败");
            springbootResponse.setData(null);
        }
        return springbootResponse;
    }


}
