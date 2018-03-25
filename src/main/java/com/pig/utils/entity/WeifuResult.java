package com.pig.utils.entity;

/**
 * Created by weifuZhow 
 */
public class WeifuResult {
	
	private static final int successCode 	 	= 200;
	private static final String successMsg		= "请求成功";

    private int  code = 200;

    private String msg = "";

    private Object data = null;
    
    
    public WeifuResult() {
    }

    public WeifuResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 默认code 200
     */
    public WeifuResult(String msg) {
        this.code = successCode;
        this.msg = msg;
    }
    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
    private static WeifuResult getInstance() {
    	return new WeifuResult();
    }

    public static WeifuResult getIsOkResult(Object data) {
    	WeifuResult result = getInstance();
    	result.setCode(successCode);
    	result.setMsg(successMsg);
    	result.setData(data);
    	return result;
    }
    
    public static WeifuResult getIsErrorResult(int code, String msg, Object data) {
    	WeifuResult result = getInstance();
    	result.setCode(code);
    	result.setMsg(msg);
    	result.setData(data);
    	return result;
    }
    
}
