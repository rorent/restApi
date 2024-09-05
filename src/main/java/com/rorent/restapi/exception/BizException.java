package com.rorent.restapi.exception;

import lombok.Getter;

@Getter
public class BizException extends RuntimeException {

	private static final long serialVersionUID = -1009732554191309175L;

	private BizErrorCode bizErrorCode;

	public BizException(BizErrorCode bizErrorCode) {
		this.bizErrorCode = bizErrorCode;
	}

	public BizException(Throwable e, BizErrorCode bizErrorCode) {
		super(bizErrorCode.getMessage());
		this.bizErrorCode = bizErrorCode;
	}
}
