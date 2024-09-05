package com.rorent.restapi.exception;

import java.util.Optional;

public class BizException extends RuntimeException {
	private static final long serialVersionUID = -4296009690948190484L;
	private ErrorCode errorCode;

	public BizException(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public BizException(Throwable e, ErrorCode errorCode) {
		super(Optional.of(errorCode.getMessage()).orElse(errorCode.getStatus().getReasonPhrase()), e);
		this.errorCode = errorCode;
	}
}
