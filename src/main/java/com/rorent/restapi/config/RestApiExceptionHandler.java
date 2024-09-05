package com.rorent.restapi.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rorent.restapi.exception.BizException;
import com.rorent.restapi.exception.SysException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class RestApiExceptionHandler {

	@ExceptionHandler(BizException.class)
	protected ResponseEntity<?> handleBizException(HttpServletRequest request, BizException e){
		return ResponseEntity.ok().body(
			BaseResponse.builder()
				.resultCode(e.getBizErrorCode().getCode())
				.resultMesssage(e.getBizErrorCode().getMessage())
				.build()
		);
	}

	@ExceptionHandler(SysException.class)
	protected ResponseEntity<?> handleBizException(HttpServletRequest request, SysException e){
		return ResponseEntity.status(e.getSysErrorCode().getStatus()).body(
			BaseResponse.builder()
				.resultCode(e.getSysErrorCode().getCode())
				.resultMesssage(e.getSysErrorCode().getMessage())
				.build()
		);
	}
}
