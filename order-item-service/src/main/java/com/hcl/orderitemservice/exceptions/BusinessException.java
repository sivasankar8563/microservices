package com.hcl.orderitemservice.exceptions;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.http.HttpStatus;

public class BusinessException extends BaseException
{

	private static final long serialVersionUID = 1L;

	private int id;
	private HttpStatus httpStatus=HttpStatus.UNPROCESSABLE_ENTITY;
	private String errorCode;
	private String errorModule;
	private String exceptionMessage;
	private String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
	
	public BusinessException(String errorCode, String errorModule, String exceptionMessage) {
		super(errorCode, errorModule, exceptionMessage);
		this.errorCode = errorCode;
		this.errorModule = errorModule;
		this.exceptionMessage = exceptionMessage;
	}

	public BusinessException(HttpStatus httpStatus, String errorCode, String errorModule, String exceptionMessage,
			String timeStamp) {
		super(httpStatus, errorCode, errorModule, exceptionMessage,timeStamp);
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
		this.errorModule = errorModule;
		this.exceptionMessage = exceptionMessage;
		this.timeStamp = timeStamp;
	}


	public String getErrorModule() {
		return errorModule;
	}


	public void setErrorModule(String errorModule) {
		this.errorModule = errorModule;
	}


	public BusinessException(HttpStatus httpStatus, String errorCode, String exceptionMessage) {
		super(httpStatus, errorCode, exceptionMessage);
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
		this.exceptionMessage = exceptionMessage;
	}
	
	
	public BusinessException(HttpStatus httpStatus, String errorCode,String errorModule, String exceptionMessage) {
		super(httpStatus, errorCode, exceptionMessage);
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
		this.errorModule = errorModule;
		this.exceptionMessage = exceptionMessage;
	}


	public BusinessException(HttpStatus httpStatus, String errorCode) {
		super(httpStatus, errorCode);
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
	}


	public BusinessException(String errorCode, String exceptionMessage) {
		super(errorCode, exceptionMessage);
		this.errorCode = errorCode;
		this.exceptionMessage = exceptionMessage;
	}


	public Integer getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}


	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}


	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}


	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	

	

}
