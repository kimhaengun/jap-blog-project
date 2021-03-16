package com.cos.blog.domain.reply;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import com.cos.blog.domain.user.RoleType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // 시퀀스, auto_increment

	@Column(nullable = false, length = 200) // nullable = false 무조건 값이 있어야함
	private String content;
	
	//유저
	
	//포스트
	
	//양방향 매핑
	
	@CreationTimestamp
	private Timestamp creDateTime; // sql
}
