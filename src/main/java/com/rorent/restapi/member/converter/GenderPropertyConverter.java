package com.rorent.restapi.member.converter;

import org.springframework.data.mongodb.core.convert.MongoConversionContext;
import org.springframework.data.mongodb.core.convert.MongoValueConverter;

import com.rorent.restapi.user.enums.Gender;
import com.rorent.restapi.util.LegacyCodeEnumValueConverterUtils;

public class GenderPropertyConverter implements MongoValueConverter<Gender, String> {


	@Override
	public Gender read(String value, MongoConversionContext context) {
		return LegacyCodeEnumValueConverterUtils.ofLegacyCode(Gender.class, value);
	}

	@Override
	public String write(Gender value, MongoConversionContext context) {
		return LegacyCodeEnumValueConverterUtils.toLegacyCode(value);
	}
}
