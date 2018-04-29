# Spring Security

* Spring Security를 이해하기 위해 정리하는 자료입니다.

## Spring Security의 목적

1. **Authentication(인증)**
2. **Authorization(인가)**

## Security 인증 순서

1. UserDetailsService에서 loadUserByUsername으로 유저를 조회한다.
2. 조회한 유저를 AuthencationProvider로 리턴해준다.
3. AuthencationProvider에서 authenticate로 비밀번호를 확인한다.
4. 인증이 성공하면 authenticate에서 authentication객체를 리턴한다.
5.  SecurityContextHolder.getContext().getAuthentication()으로 유저 정보를 불러온다.

## UserDetailsService

* loadUserByUsername() 을 구현


* DB에서 유저 정보를 조회하려면 UserDetailsService interface 구현

## AuthenticationProvider

* 인증 로직
* 비밀번호 비교를 직접 구현시 AuthenticationProvider 구현

## 감사 인사

* https://docs.spring.io/spring-security/site/docs/5.0.4.RELEASE/reference/htmlsingle/


* http://odol87.tistory.com/7
* http://syaku.tistory.com/286
* https://okky.kr/article/382738
* http://cusonar.tistory.com/17
* http://netframework.tistory.com/entry/REST-API-%EA%B5%AC%EC%84%B1%EC%8B%9C-Spring-Security-%EA%B5%AC%ED%98%84
* https://minwan1.github.io/2017/03/25/2017-03-25-spring-security-theory/
* 그 외 많은 분들..