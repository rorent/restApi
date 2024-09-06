package com.rorent.restapi.post.model;

import com.rorent.restapi.config.model.BaseEntity;
import com.rorent.restapi.user.model.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_post")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Post extends BaseEntity {

	/*
	 * GenerationType.IDENTITY 	: 	기본키 생성을 데이터베이스에 위임(auto increments) #em.persist 시 쿼리 실행, Batch Insert(saveAll) 허용 불가
	 * GenerationType.SEQUENCE	: Database sequence 사용
	 * GenerationType.AUTO		: 자동 지정
	 * GenerationType.TABLE		: Key Table 활용
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)    /* Auto_increments */
	private Long id;

	@Column(length = 200, nullable = false)
	private String title;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;

	@Column(columnDefinition = "integer default 0", insertable = false)
	private int viewCount;

	@ManyToOne(fetch = FetchType.LAZY) // 지연 로딩 사용
	@JoinColumn(name = "user_id")
	private User user;

	@Builder
	public Post(Long id, String title, User user, String content) {
		this.id = id;
		this.title = title;
		this.user = user;
		this.content = content;
	}
}








