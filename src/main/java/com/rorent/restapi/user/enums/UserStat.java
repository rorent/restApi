package com.rorent.restapi.user.enums;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.rorent.restapi.config.LegacyCodeCommonType;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserStat implements LegacyCodeCommonType {

	NORMAL("10", "정상"),
	RESTING("50", "휴면"),
	DELETE("99", "삭제")
	;

	@JsonValue		//To identify Response return value
	private String code;
	private String desc;

	@JsonCreator
	public static UserStat ofCode(String code){
		return Arrays.stream(UserStat.values())
				.filter(v -> v.getLegacyCode().equals(code))
				.findAny().orElse(null);
	}

	@Override
	public String getLegacyCode() {
		return this.code;
	}

	@Override
	public String getDesc() {
		return this.desc;
	}
}
