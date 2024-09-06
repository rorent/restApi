package com.rorent.restapi.user.converter;

import com.rorent.restapi.user.enums.Gender;
import com.rorent.restapi.util.AbstractLegacyEnumAttributeConverter;

import jakarta.persistence.Converter;

@Converter
public class GenderConverter extends AbstractLegacyEnumAttributeConverter<Gender> {

	public static final String ENUM_NAME = "성별";

	public GenderConverter() {
		super(Gender.class, ENUM_NAME);
	}
}
