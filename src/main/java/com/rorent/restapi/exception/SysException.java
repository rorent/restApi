package com.rorent.restapi.exception;

import java.util.Optional;

import lombok.Getter;

@Getter
public class SysException extends RuntimeException {
	private static final long serialVersionUID = -4296009690948190484L;
	private SysErrorCode sysErrorCode;

	public SysException(SysErrorCode sysErrorCode) {
		this.sysErrorCode = sysErrorCode;
	}

	public SysException(Throwable e, SysErrorCode sysErrorCode) {
		super(Optional.of(sysErrorCode.getMessage()).orElse(sysErrorCode.getStatus().getReasonPhrase()), e);
		this.sysErrorCode = sysErrorCode;
	}
}
