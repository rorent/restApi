package com.rorent.restapi.user.converter;

import com.rorent.restapi.user.enums.UserStat;
import com.rorent.restapi.util.AbstractLegacyEnumAttributeConverter;

import jakarta.persistence.Converter;

@Converter
public class UserStatConverter extends AbstractLegacyEnumAttributeConverter<UserStat> {

	public static final String ENUM_NAME = "사용자 상태";

	public UserStatConverter() {
		super(UserStat.class, ENUM_NAME);
	}
}
