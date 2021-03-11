package com.cos.blog.web;



import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.config.auth.PrincipalDetails;
import com.cos.blog.domain.user.User;

@Controller
public class UserController {
   
	//로그인, 로그아웃, 회원가입, 회원정보 변경(AuthController)
	
	//
	
   @GetMapping("/user")
   public @ResponseBody String findAll(@AuthenticationPrincipal PrincipalDetails principalDetails) { 
	   // @Controller + @ResponseBody = @RestController
	   //세션 확인 방법(1)
//	   Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//	   PrincipalDetails principalDetails = (PrincipalDetails)authentication.getPrincipal();
//	   System.out.println(principalDetails.getUser());
//	   (2)@AuthenticationPrincipal 어노테이션 걸어주기
	   System.out.println(principalDetails.getUsername());
      return "User";
   }

}
