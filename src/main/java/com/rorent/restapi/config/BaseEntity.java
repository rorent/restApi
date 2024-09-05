package com.rorent.restapi.config;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
public abstract class BaseEntity {

	@CreationTimestamp
	@Column(updatable = false, nullable = false)
	private LocalDateTime createDtm;

	@UpdateTimestamp	//생성시에도 dtm 적용.
	@Column(nullable = false)
	private LocalDateTime updateDtm;

}
