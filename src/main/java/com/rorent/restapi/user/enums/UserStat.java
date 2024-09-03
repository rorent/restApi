package com.rorent.restapi.user.enums;

import java.util.Arrays;

import com.rorent.restapi.config.LegacyCodeCommonType;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserStat implements LegacyCodeCommonType {
	NORMAL("10", "정상"),
	RESTING("50", "휴면"),
	DELETE("99", "삭제")
	;

	private String code;
	private String desc;

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
