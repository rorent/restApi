package com.rorent.restapi.config.model;

import java.io.Serializable;

import com.rorent.restapi.exception.BizErrorCode;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BaseResponse<T> implements Serializable {

	private static final long serialVersionUID = 8731570989543562378L;

	private String resultCode;

	private String resultMesssage;

	private T data;

	public BaseResponse() {
		this(BizErrorCode.SUCCESS, null);
	}

	public BaseResponse(T data) {
		this(BizErrorCode.SUCCESS, data);
	}

	public BaseResponse(String resultCode, String resultMesssage) {
		this(resultCode, resultMesssage, null);
	}



	public BaseResponse(BizErrorCode bizErrorCode, T data){
		this(bizErrorCode.getCode(), bizErrorCode.getMessage(), data);
	}

	@Builder
	public BaseResponse(String resultCode, String resultMesssage, T data) {
		this.resultCode = resultCode;
		this.resultMesssage = resultMesssage;
		this.data = data;
	}
}
