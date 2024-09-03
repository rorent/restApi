package com.rorent.restapi.config;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class BaseResponse<T> implements Serializable {

	private static final long serialVersionUID = 8731570989543562378L;

	private String resultCode;

	private String resultMesssage;

	private T data;

	public BaseResponse() {
		this("0000", "성공", null);
	}

	public BaseResponse(T data) {
		this("0000", "성공", data);
	}

	public BaseResponse(String resultCode, String resultMesssage) {
		this(resultCode, resultMesssage, null);
	}

	public BaseResponse(String resultCode, String resultMesssage, T data) {
		this.resultCode = resultCode;
		this.resultMesssage = resultMesssage;
		this.data = data;
	}
}
