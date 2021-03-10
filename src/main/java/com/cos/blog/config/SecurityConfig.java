package com.cos.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration // 설정, 메모리에 띄움 ioc에 등록
@EnableWebSecurity // 이제 커스터마이징한 시큐리티가 실행된다.
public class SecurityConfig extends WebSecurityConfigurerAdapter{ // 어댑터는 함수를 걸러줌, 강제성을 없애준다.
   
   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
         .antMatchers("/user","/post").authenticated() // authenticated 두개만 허용해주는 것, 열리는 것 
         .anyRequest().permitAll() // 나머지는 전부 허용해준다. 
         .and() // 여기서 끝
         .formLogin() // x-www-form-urlencoded , json으로 던지면 안된다. 결국 폼태그를 만들어야한다.
         .loginPage("/loginForm"); // user, post 호출 시 로그인 페이지로 리다이렉션됨 
   }

}
