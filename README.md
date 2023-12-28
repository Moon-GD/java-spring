# Hello Spring 학습 이력
#### 자료 출처: <a href="https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8">인프런의 김영한님의 스프링 강의</a> → 오직 학습의 목적으로만 활용됩니다.


<details>
  <summary>Spring boot libraries</summary>

  - spring-boot-starter-web
    - spring-boot-start-tomcat: 톰캣 웹 서버
    - spring-webmvc: 스프링 웹 MVC
  - spring-boot-starter-thymeleaf: 템플릿 엔진 (View)
  - spring-boot-starter 
    - spring-boot
      - spring-core
    - spring-boot-starter-logging
      - 콘솔이 아닌 로그로 관리하는 것이 중요 에러를 그룹화 하는 등 사용성이 좋다
      - logback (slf4j를 구현한 기능 느낌)
      - slf4j (인터페이스)

<br />

- spring-boot-starter-test: 테스트 라이브러리
  - junit: 테스트 프레임워크
    - 버전 넘어가는 중 : 4 → 5
  - mockito: 목 라이브러리
  - assertj: 테스트 코드를 좀 더 편하게 작성하게 도와주는 라이브러리
  - spring-test: 스프링 통합 테스트 지원

<hr />
    
##### updated: 2023.12.28 (Thr)

</details>

<!-- 토글 구분을 위한 주석  -->

<details>
    <summary>welcome page & template 엔진 동작 방식</summary>

- 배운 점
  - `src/main/java/프로젝트 경로`에 controller 패키지를 생성하면 스프링에서 컨트롤러가 필요할 때 알아서 이 쪽을 바라본다
  - 컨트롤러에서 ui 패키지의 model 객체와 반환 String 값을 viewResolver로 전달 <br />
  → 반환 값을 따라 올바른 html 파일을 추적하고, 필요한 템플릿 변수를 Model 객체에서 탐색
  → 최종적으로, html 파일로 변환한 이후 톰캣 서버를 거쳐 웹 브라우저에 반환


- 과정
  - 타임 리프 템플릿의 기본적인 활용과 동작 방식을 이해하기 위해 임의로 Get 관련 컨트롤러를 생성
  - `resources/templates` 하위에 위의 컨트롤러에서 반환하는 String 값에 맞게 html 파일을 생성
  - url 경로 따라서 가보니 생성한 welcome page 확인!
  - 동작 방식 흐름도 ↓
  - <img width="1000" alt="동작 방식" src="https://github.com/Moon-GD/java-spring/assets/74173976/890e5ebd-e9d8-47ce-89f3-593817e4f9cb" />
     
</details>

<!-- 토글 구분을 위한 주석  -->

<hr />

    updated: 2023.12.28 (Thr)