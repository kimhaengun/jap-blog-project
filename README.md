# jpa-blog-project
### 의존성

- Spring web

### MySQL 데이터베이스 생성 및 사용자 생성

```sql
create user 'pos'@'%' identified by 'pos1234';
GRANT ALL PRIVILEGES ON *.* TO 'pos'@'%';
create database pos;
```

### 메인 화면

JSTL문법을 사용하여 세션이 없으면 로그인, 회원가입 문구를 출력하고

세션이 있을 경우 글쓰기, 회원정보보기, 로그아웃 문구를 출력한다.

로그인이 되어 있을경우 

http://localhost:8080/logout, 로그아웃을 클릭하면 세션이 날라간다.

메인 페이지 이기 때문에 Post테이블에 있는 데이터를 3개씩 페이징하며 모두 뿌려줌

검색 시 검색 단어를 JpaRepository findByTitle 내부함수를 이용하여 sql 실행

