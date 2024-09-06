package com.rorent.restapi.member.model;

import java.time.LocalDate;

import org.springframework.data.convert.ValueConverter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.rorent.restapi.member.converter.GenderPropertyConverter;
import com.rorent.restapi.user.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Id;


//Mongo Document

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "member")
public class Member {

	@Id
	private Long id;

	//spring.data.mongodb.auto-index-creation 설정이 true인 경우 @Indexed로 지정된 컬럼에 index가 생성된다.
	@Indexed
	private String mbrName;

	//Mongo convert 방식
	@ValueConverter(value = GenderPropertyConverter.class)
	private Gender genderCd;

	private LocalDate birth;

	private String mbrEmail;

}
