package com.cos.blog.web;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.config.auth.PrincipalDetails;
import com.cos.blog.domain.post.Post;
import com.cos.blog.service.PostService;
import com.cos.blog.web.post.dto.PostSaveReqDto;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;

@RequiredArgsConstructor
@Controller
public class PostController {
	private final PostService postService;
	
	@GetMapping("/")
	public String findAll(Model model,
			@PageableDefault(sort = "id",direction = Sort.Direction.DESC,size = 3)Pageable pageable
			,@AuthenticationPrincipal PrincipalDetails principalDetails) {
//		System.out.println("누구로 로그인 되었을까?");
//		System.out.println(principalDetails.isOAuth());
//		//true = 구글 false = 일반사용자
//		System.out.println(principalDetails.getAttributes());
//		System.out.println(principalDetails.getUser().getUsername());		
		Page<Post> posts = postService.전체찾기(pageable);
		model.addAttribute("posts",posts); //리퀘스트 디스패쳐 포워딩한것이랑 같다.
		return "post/list";
	}
	
	@GetMapping("/post/saveForm")
	public String saveForm() {
		return "post/saveForm";
	}
	
	@GetMapping("/post/{id}")
	public String detail(@PathVariable int id, Model model) {
		Post postEntity = postService.상세보기(id);
		model.addAttribute("post",postEntity);
		return "post/detail"; //ViewResolver = jsp파일을 찾아줌
	}
	
	@PostMapping("/post")
	public String save(PostSaveReqDto postSaveReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		Post post = postSaveReqDto.toEntity();
		post.setUser(principalDetails.getUser()); //연관관계를 위해서 작성한다.
		Post postEntity = postService.글쓰기(post);
		
		if(postEntity == null) {
			return "post/saveForm";
		}else {
			return "redirect:/";
		}
	}
}
