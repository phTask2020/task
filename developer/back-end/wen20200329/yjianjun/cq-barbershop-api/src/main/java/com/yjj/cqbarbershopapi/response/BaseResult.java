package com.yjj.cqbarbershopapi.response;

import lombok.Data;

@Data
public class BaseResult {
    private boolean success;
    private String errMsg;

    public BaseResult(boolean success, String errMsg) {
        this.success = success;
        this.errMsg = errMsg;
    }
//
//    public boolean isSuccess() {
//        return success;
//    }
//
//    public void setSuccess(boolean success) {
//        this.success = success;
//    }
//
//    public String getErrMsg() {
//        return errMsg;
//    }
//
//    public void setErrMsg(String errMsg) {
//        this.errMsg = errMsg;
//    }
}
