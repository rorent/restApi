package com.rorent.restapi.util;

import java.text.MessageFormat;

import com.rorent.restapi.config.LegacyCodeCommonType;

import lombok.Getter;

import jakarta.persistence.AttributeConverter;

@Getter
public class AbstractLegacyEnumAttributeConverter<E extends Enum<E> & LegacyCodeCommonType> implements AttributeConverter<E, String> {

	/*
	* 대상 Enum Class 객제{@link Class}
	* */
	private Class<E> targetEnumClass;

	/*
	* {@NotNull Enum} Enum에 대한 오류 메시지 출력에 사용
	* */
	private String enumName;

	public AbstractLegacyEnumAttributeConverter(Class<E> targetEnumClass, String enumName) {
		this.targetEnumClass = targetEnumClass;
		this.enumName = enumName;
	}

	@Override
	public String convertToDatabaseColumn(E attribute) {
		//모든 Enum 타입 컬럼엔 null, "" 불가
		if(attribute == null){
			throw new IllegalArgumentException(MessageFormat.format("{{은 NULL로 저장할 수 없습니다.", enumName));
		}
		return LegacyCodeEnumValueConverterUtils.toLegacyCode(attribute);
	}

	@Override
	public E convertToEntityAttribute(String dbData) {
		return LegacyCodeEnumValueConverterUtils.ofLegacyCode(targetEnumClass, dbData);
	}
}
