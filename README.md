# Hello Spring 학습 이력
#### 자료 출처: <a href="https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8">인프런의 김영한님의 스프링 강의</a> → 오직 학습의 목적으로만 활용됩니다.

<details>
<summary>2023.12.28 (Thr)</summary>
<ul>
<li>
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

</details>
</li>
        
<!-- li 태그 구분을 위한 주석  -->

<li>
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

<hr />
    
</details>        
</li>

<!-- li 태그 구분을 위한 주석  -->

<li>

<details>
<summary>CLI build & run build file</summary>

- 우선, FE 전용으로 썼던 PC라 Java 기본 설정이 잘 되어 있지 않았는데 아래의 과정으로 JAVA_HOME을 올바르게 바라보도록 설정했다
- build 할 때 java 경로 따라가야 하기 때문에 올바르게 설정하지 않으면 아래의 오류 메세지가 출력됨
- <details>
    <summary>Java 경로 관련 오류 메세지 보기</summary>

    ```bash
      "ERROR: JAVA_HOME is set to an invalid directory: '올바르지 못한 경로'. 
      Please set the JAVA_HOME variable in your environment to match the location of your Java installation."
    ```
  </details>
- <details>
    <summary>해결 방법</summary>

  ```shell
      # JAVA_HOME 경로 확인  
      $  /usr/libexec/java_home
  
      # .zshrc 파일에 반영하기 위해 이동
      $ cd ~/.zshrc
  
      # .zshrc 파일 JAVA 쪽 설정에 아래 내용 추가
      export JAVA_HOME=JAVA_HOME 경로
  
      # 터미널에 .zshrc 파일 변경 사항 즉시 반영
      $ source ~/.zshrc
    ```
   </details>

- build 방법
  ```shell
  # build 대상이 되는 스프링 프로젝트의 루트에서
  
  # build
  $ ./gradlew build
  
  # 빌드되면 build 폴더가 생성됨
  
  # jar 파일 실행
  $ java -jar ./build/libs/jar 파일
  
  # ❗️ 혹시나 build 안되면 아래 명령어 중 하나 실행하기
  ## build 결과물, 임시 파일 모두 제거
  $ ./gradlew clean
  
  ## build 결과물, 임시 파일 모두 제거 이후 빌드 실행
  $ ./gradlew clean build
  
  # 혹은, 로컬의 스프링이 Port 번호를 먼저 사용 중인지 확인하기
  ```

- 위의 build & run 과정을 통해 실제 호스팅에서 어떻게 배포하는지 가늠을 잡았다 😁

</details>

<hr />

</li>

</ul>

</details>

<!-- details 태그 구분을 위한 주석 -->

<details>
<summary>2023.12.31 (Sun)</summary>

<ul>

<li>

<details>

<summary>MVC와 템플릿 엔진</summary>

- 컨트롤러 인자에 @RequestParam을 활용하여 url parameter 값을 템플릿 엔진에 넘길 수 있다.
- 타임리프 템플릿의 경우 서버 구동 없이 Html 파일을 열게 되면 동적 생성 없이 태그 내부의 값을 렌더링한다

```html
<p th:text="'name : ' + ${name}">단순 Html 불러오기</p>

서버 구동한 경우 → "name : `model의 name 값`" 이 출력
html 정적으로 보는 경우 → "단순 Html 불러오기"가 출력 
```

</details>

</li>

<!-- li 태그 구분을 위한 주석 -->

<li>

<details>

<summary>API</summary>

<img src="https://github.com/Moon-GD/java-spring/assets/74173976/ccb909a3-9e33-4568-bfda-422ca9730179" alt="@ResposneBody 동작 방식" />

- @ResponseBody가 표기된 controller는 최종 가공된 정보를 `viewResolver`가 아닌 `HttpMessageConverter`로 넘긴다
- 이 때 정보의 유형에 따라 내부 converter 유형이 달라진다 (Request 헤더 값은 고려하지 않는 것으로 가정)
  - String: String Converter
  - Object: Json Converter
    - 과거에는 xml도 사용되었지만, Spring에서는 Json을 기본 값으로 설정해 둠.

#### 참고
- 코드 한 줄 완성 단축키 : Command + Shift + Enter
- 클래스 내부에서 generate 호출 단축키 : Command Enter

</details>

</li>

<!-- li 태그 구분을 위한 주석 -->

</ul>

</details>

    updated: 2023.12.31 (Sun)
