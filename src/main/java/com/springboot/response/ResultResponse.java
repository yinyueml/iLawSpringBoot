package com.springboot.response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by shaowei on 2017/3/22.
 */
public class ResultResponse {
    @ApiModelProperty(value="结果码",notes = "1成功、0失败")
    private String resultCode;
    @ApiModelProperty(value="结果消息")
    private String resultMessage;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
