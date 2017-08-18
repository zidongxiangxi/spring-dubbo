package com.xdchen.server.common.exception;

public class ApiException extends RuntimeException {
    private int errCode;
    private String errMsg;
    private Object data;

    public ApiException(int errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.data = null;
    }

    public ApiException(int errCode, String errMsg, Object data) {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.data = data;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
