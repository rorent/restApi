package com.rorent.restapi.user.converter;

import com.rorent.restapi.user.enums.Gender;
import com.rorent.restapi.util.AbstractLegacyEnumAttributeConverter;

import jakarta.persistence.Converter;

@Converter
public class GenderTypeConverter extends AbstractLegacyEnumAttributeConverter<Gender> {

	public static final String ENUM_NAME = "성별";

	public GenderTypeConverter() {
		super(Gender.class, ENUM_NAME);
	}
}
