package com.rorent.restapi.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum SysErrorCode {
	/** invalid header exception */
	INVALID_HEADER_EXCEPTION(HttpStatus.PRECONDITION_FAILED, "412", "Invalid Header Value"),
	/** invalid id secret exception */
	INVALID_ID_SECRET_EXCEPTION(HttpStatus.UNAUTHORIZED, "401", "Invalid ID/Secret Header"),
	/** method not allowed */
	METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "405"),
	NOT_FOUND_DATA(HttpStatus.UNPROCESSABLE_ENTITY, "422", "NOT FOUND DATA"),
	/** internal server error */
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500"),
	;
	private final HttpStatus status;
	private final String code;
	private String message;


	private SysErrorCode(HttpStatus status, String code) {
		this.status = status;
		this.code = code;
	}

	private SysErrorCode(HttpStatus status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}
}