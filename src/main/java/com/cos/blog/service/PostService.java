package com.cos.blog.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.domain.post.Post;
import com.cos.blog.domain.post.PostRepository;
import com.cos.blog.domain.user.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostService {
	private final PostRepository postRepository;
	
	@Transactional(readOnly = true)
	public Page<Post> 전체찾기(Pageable pageable){
		return postRepository.findAll(pageable);
	}
	
	@Transactional
	public Post 글쓰기(Post post) {
		return postRepository.save(post);
	}
	
	@Transactional(readOnly = true)
	//영속성 컨텐츠가 변경감지 x /필요없는 연산x
	public Post 상세보기(int id) {
		return postRepository.findById(id).get();
	}
}
