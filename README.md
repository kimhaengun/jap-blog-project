# jpa-blog-project
### 의존성

- Spring web

### MySQL 데이터베이스 생성 및 사용자 생성

```sql
create user 'pos'@'%' identified by 'pos1234';
GRANT ALL PRIVILEGES ON *.* TO 'pos'@'%';
create database pos;
```

### 실행 화면
https://user-images.githubusercontent.com/74044234/122167964-a4409e00-ceb6-11eb-8f44-c76b4fc63936.mp4



### 메인 화면

JSTL문법을 사용하여 세션이 없으면 로그인, 회원가입 문구를 출력하고

세션이 있을 경우 글쓰기, 회원정보보기, 로그아웃 문구를 출력한다.

로그인이 되어 있을경우 

http://localhost:8080/logout, 로그아웃을 클릭하면 세션이 날라간다.

메인 페이지 이기 때문에 Post테이블에 있는 데이터를 3개씩 페이징하며 모두 뿌려줌

검색 시 검색 단어를 JpaRepository findByTitle 내부함수를 이용하여 sql 실행

![메인1](https://user-images.githubusercontent.com/74044234/122168109-d225e280-ceb6-11eb-9ae3-2c789816c404.jpg)
![메인2](https://user-images.githubusercontent.com/74044234/122168115-d4883c80-ceb6-11eb-83fe-76ef40779eec.jpg)

### 회원가입

로그인에서 회원가입을 클릭하면 Get요청으로  회원가입 페이지를 리턴하고

회원가입시 비밀번호는 BCryptPasswordEncoder를 이용하여 암호화되어 데이터베이스에 저장된다. / 권한은 USER로 통일 회원가입이 완료되면  로그인할 수 있도록 로그인 페이지로 redirect

![회원가입](https://user-images.githubusercontent.com/74044234/122168189-eb2e9380-ceb6-11eb-9a8d-b67fb28a8661.jpg)

### 로그인

<기존 로그인>

From 테그를 사용하여 POST요청

로그인을 클릭하면 /login 주소로 요청을 하게 되는데 이때 Spring security가 낚아 챈후

(1) 

x-www-form-urlencoded데이터가 들어 왔다고 가정하고 username, poassword를 파싱

(2)

파싱이 끝난 username, password로 객체를 생성.

(3)

해당 객체를 AuthenticationManager한테 해당 객체를 전달한다.

*AuthenticationManager의 목적은 로그인을 하기 위해

(4)

로그인하기 위해 loadByUsername함수가 실행되고 유저가 DB에 있는지 검증

유저가 있을 경우 PrincipalDetails.java가 실행되고 마지막 리턴을 UserDetails를 리턴하는데 AuthenticationManager가 그 값을 Authentication객체로 변환

//세션 유저로 로그인

<Oauth 로그인>

Code 방식 사용

![로그인](https://user-images.githubusercontent.com/74044234/122168225-fa154600-ceb6-11eb-8273-c3f52d110c20.jpg)

### 회원수정

회원정보보기를 클릭하면 Get으로 /user/{id}주소를 요청하고 세션 id 정보를 model에담아서 회원 수정 페이지를 리턴하여 로그인한 회원정보가 담긴 페이지가 리턴됨.

회원수정 버튼을 클릭하면 세션 id로 유저 정보를 찾아 UserService에서 input테그에 저장된 값으로 바꾸고 세션변경을 위해 principalDetails로 이동하여 변경된값(userEntity)을 저장

![회원정보수정](https://user-images.githubusercontent.com/74044234/122168243-039eae00-ceb7-11eb-85f9-1c1049c39036.jpg)

### 글쓰기

글쓰기는 Summernote를 사용

PostController → PostService → PostRepository 

글쓰기완료 클릭 시 Post요청으로 Post테이블에 저장되며 글쓰기는 로그인한 유저만 가능, 로그인이 안되어 있으면 메인(/)페이지로 이동하게 된다.
![글쓰기](https://user-images.githubusercontent.com/74044234/122168282-0f8a7000-ceb7-11eb-9073-7d4fe237bfe2.jpg)

### 상세보기

삭제의 경우 Form테그는 Delete요청을 할 수 없기 때문에 ajax로 구현하였다.

*Form테그는 post,get요청 가능 delete는 불가능..

*ajax는 비동기의 목적으로만 사용하기 않음!!

로그인한 유저가 자신이 쓴 게시물을 상세보기 시 게시물 수정, 삭제 기능이 가능하며

![01](https://user-images.githubusercontent.com/74044234/122168469-482a4980-ceb7-11eb-8dbc-cb1181687833.jpg)

내가 쓴 게시물이 아닐경우 수정, 삭제 기능을 사용할 수 없다.

![02](https://user-images.githubusercontent.com/74044234/122168547-61cb9100-ceb7-11eb-82a6-1176df31aa54.jpg)

### 댓글

댓글 추가, 삭제 기능 경우 페이지 전체를 리로딩하는것이 아닌 부분 리로딩을 하기 위해서 ajax(비동기)를 사용하였다.


