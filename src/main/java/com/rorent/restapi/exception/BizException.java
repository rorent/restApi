package com.rorent.restapi.exception;

public class BizException extends RuntimeException {
	private int status;
	private String code;
	private String message;

	public BizException(int status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}
}
