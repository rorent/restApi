package com.rorent.restapi.user.enums;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.rorent.restapi.config.LegacyCodeCommonType;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Gender implements LegacyCodeCommonType {
	MAN("10", "남자"),
	WOMAN("20", "여자")
	;

	private String code;
	private String desc;

	@JsonCreator	//RequestBody String to Enum Code Mapping
	public static Gender ofCode(String code){
		return Arrays.stream(Gender.values())
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
