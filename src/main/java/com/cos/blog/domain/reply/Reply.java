package com.cos.blog.domain.reply;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;

import com.cos.blog.domain.post.Post;
import com.cos.blog.domain.user.RoleType;
import com.cos.blog.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	//포스트
	@ManyToOne
	@JoinColumn(name = "postId")
	private Post post;
	
	
	@CreationTimestamp
	private Timestamp creDateTime;  // sql
}
