package com.rorent.restapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BizErrorCode {
	SUCCESS("0000", "성공"),
	INVALID_PARAM("1001", "잘못된 파라미터"),
	EXIST_DATA("1002", "존재하는 데이터")
	;

	private String code;
	private String message;
}
