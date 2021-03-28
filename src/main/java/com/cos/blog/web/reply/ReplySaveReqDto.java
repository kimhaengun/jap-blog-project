package com.cos.blog.web.reply;

import com.cos.blog.domain.post.Post;
import com.cos.blog.domain.reply.Reply;

import lombok.Data;

@Data
public class ReplySaveReqDto {
	private String content;
	private Integer postId;
	
	public Reply toEntity() {
		return Reply.builder()
				.content(content)
				.post(Post.builder().id(postId).build())
				.build();
	}
	
}
