package com.rorent.restapi.user.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.rorent.restapi.config.BaseEntity;
import com.rorent.restapi.user.converter.GenderTypeConverter;
import com.rorent.restapi.user.converter.UserStatConverter;
import com.rorent.restapi.user.enums.Gender;
import com.rorent.restapi.user.enums.UserStat;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class TbUserVO extends BaseEntity {

	/*
	* GenerationType.IDENTITY 	: 	기본키 생성을 데이터베이스에 위임(auto increments) #em.persist 시 쿼리 실행, Batch Insert(saveAll) 허용 불가
	* GenerationType.SEQUENCE	: Database sequence 사용
	* GenerationType.AUTO		: 자동 지정
	* GenerationType.TABLE		: Key Table 활용
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	/* Auto_increments */
	private Long userId;

	@Column(nullable = false)
	private String userName;

	@Convert(converter = GenderTypeConverter.class)		//Enum Converter 적용
	@Column(nullable = false)
	private Gender genderCd;

	private LocalDate birth;

	private String userEmail;

	@Convert(converter = UserStatConverter.class)
	@Column(nullable = false)
	private UserStat userStatCd;

	@Builder
	public TbUserVO(Long userId, String userName, Gender genderCd, LocalDate birth, String userEmail, UserStat userStatCd) {
		this.userId = userId;
		this.userName = userName;
		this.genderCd = genderCd;
		this.birth = birth;
		this.userEmail = userEmail;
		this.userStatCd = userStatCd;
	}
}
