package com.rorent.restapi.util;

import java.text.MessageFormat;
import java.util.EnumSet;

import org.springframework.util.StringUtils;

import com.rorent.restapi.config.LegacyCodeCommonType;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LegacyCodeEnumValueConverterUtils {

	//Legacy code -> Enum 변환
	public static <T extends Enum<T> & LegacyCodeCommonType> T ofLegacyCode(Class<T> enumClass, String legacyCode){
		if(!StringUtils.hasText(legacyCode)){
			return null;
		}

		return EnumSet.allOf(enumClass).stream()
				.filter(e -> e.getLegacyCode().equals(legacyCode))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException(MessageFormat.format("enum={}에 legacyCode={}가 존재하지 않습니다.", enumClass.getName(), legacyCode)));
	}

	//Enum -> Legacy code
	public static <T extends Enum<T> & LegacyCodeCommonType> String toLegacyCode(T enumValue){
		return enumValue.getLegacyCode();
	}
}
