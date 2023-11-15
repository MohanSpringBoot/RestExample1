package com.app.Exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;


public class RecordsNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
	private String msg;
	
	public RecordsNotFoundException(String msg) {
		this.msg=msg;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
