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

<h4>참고</h4>
- 코드 한 줄 완성 단축키 : Command + Shift + Enter
- 클래스 내부에서 generate 호출 단축키 : Command Enter

</details>

</li>

<!-- li 태그 구분을 위한 주석 -->

</ul>

</details>

<!-- details 태그 구분을 위한 주석 -->

<details>

<summary>2024.01.01 (Mon)</summary>

<ul>

<li>

<details>

<summary>회원 도메인과 레포지토리 만들기</summary>

<h3>처음 접했던 개념</h3>

- Domain: 비즈니스 로직, DB 상호작용 등에 활용될 데이터의 형태를 추상화하여 모아둔 곳
- Repository: DB 상호작용에 필요한 구현체를 정의한 interface와 해당 interface를 구현한 class가 존재하는 곳

<br />

<h3>⁉️ 궁금했던 점 해결</h3>

- 메모리 맵 생성할 때 1번 방식으로 하는 이유

```java
import java.util.HashMap;
import java.util.Map;

// 1번
Map<Long, String> store = new HashMap<>();

// 2번
HashMap<Long, String> store = new HashMap<>();
```

→ 1번 방식의 경우 상위 클래스를 참조하기에 필요에 따라 HashMap이 아닌 다른 Map으로 교체 가능 <br />
→ 즉, HashMap으로 `store 변수`를 생성할 경우 상대적으로 유연성이 떨어지고 하위 클래스로의 의존성이 높아짐. 따라서, 일반적으로 1번 형태를 선호 

</details>

</li>

<!-- li 태그 구분을 위한 주석 -->

<li>

<details>

<summary>회원 레포지토리 테스트 케이스 작성</summary>

<br />

- 일반적인 Test 코드 파일명 컨벤션은 postfix로 Test 붙여줌
- 테스트 코드의 실행 순서는 보장받지 못하기 때문에 **항상 순서에 독립적으로 작성!**

<h3>️새로 알게 된 것</h3>

<h4>Java 8 등장 문법: Optional</h4>
- 하나의 객체로서 빈 값에 대한 처리, 기본 값 부여 등의 작업을 수행할 수 있도록 도와줌
- null에 비해 보다 안전한 처리가 가능해서 종종 활용됨.
- 값이 없을 때 get()으로 값 추출을 시도하면 `NoSuchElementException` 에러 발생

```java
Optional<string> optionalString = findValue();

// 기본 값 부여
String userName = optionalString.orElse("no name").toUpperCase();

// 빈 값 처리
String returnValue = (optionalString.isPresent()) ? 
        optionalString.get() : "Empty";
```

<br />

<h4>단축키</h4>

- 파일 트리 `focus`된 상태에서 Command + N: 파일 추가

</details>

</li>

<!-- li 태그 구분을 위한 주석 -->

<li>

<details>

<summary>회원 서비스 개발</summary>

<h4>네이밍 관련</h4>

- service: 비즈니스에 초점
- repository: 원시적인 기능에 초점

</details>

</li>

<!-- li 태그 구분을 위한 주석 -->

<li>

<details>

<summary>회원 서비스 테스트</summary>

<br />

- 테스트 코드 작성이 익숙지 않다면 `given → when → then` 순서로 작성해보는 것을 추천
- 실패 케이스에 대해서도 작성할 것

</details>

</li>

</ul>

</details>

<!-- details 태그 구분을 위한 주석 -->

<details>

<summary>2024.01.06 (Sat)</summary>

<ul>

<li>

<details>

<summary>컴포넌트 스캔과 자동 의존관계 설정</summary>

<h3>처음 알게 된 내용</h3>

<h4>스프링 컨테이너란</h4>

- 스프링 프로젝트가 구동될 때 필요한 주된 작업을 진행해주는 컨테이너
- 빈 생성 및 생태주기 관리, 빈 간의 의존성 주입 등을 담당

<br />

<h4>스프링 빈이란</h4>

- 컨트롤러, 서비스, 레포지토리 등은 프로젝트가 실행되면 스프링 컨테이너에 의해 객체로 관리되는데, 이 때 각각의 객체를 빈이라고 부른다

<br />

<h4>스프링 컨테이너에게 빈임을 알려주는 방법: 컴포넌트 스캔 방식</h4>

- 스프링 프로젝트의 메인 메소드가 존재하는 패키지 및 하위 패키지의 클래스만이 대상이 되며, 그 중 `@Component` 어노테이션이 있는 클래스가 실제로 관리 대상이 된다.
- `@Component`를 내부적으로 가지고 있는 `@Service, @Repository, @Controller`도 동일하게 관리 대상이 되도록 설정해주는 어노테이션

<br />

<h4>스프링 빈 간의 의존 관계 설정: `@AutoWired` </h4>

- 여러 빈이 생성될 때마다 필요한 인스턴스를 생성하는 것은 메모리 측면에서도 낭비
- 여기서 `@AutoWired`를 달아주면, 필요한 인스턴스 중 스프링 컨테이너에 이미 등록된 빈이 발생되면 해당 빈을 주입해준다. 
- 즉, `@AutoWired`는 스프링 빈의 재사용성을 높여주고, 의존성을 주입해주는 어노테이션
- 단, 직접 등록한 스프링 빈에서는 동작하지 않음.

</details>

</li>

<!-- details 태그 구분을 위한 주석 -->

<li>

<details>

<summary>자바 코드로 직접 스프링 빈 등록하기</summary>

- `@Config` 어노테이션을 활용한 클래스를 기반으로 스프링 빈을 등록할 수 있다
- 예전에는 XML로도 등록했지만, 현재는 잘 쓰이지 않아 Java 코드로 등록했음

<h3>의존성 주입 방식 3가지</h3>

- 생성자 활용
- 필드 주입
  - 유연성이 조금 떨어짐
- setter 주입
  - 실무에서 보면 React-hook-use의 `useMount`처럼, 프로젝트 초기 로딩에만 등록이 필요한 경우가 많은데, setter 방식의 경우 의존성 주입을 제공하는 메소드가 public하게 노출된다는 단점이 존재

<br />

<h3>스프링 빈 등록 방법을 정리해보면..</h3>

- 컨트롤러, 서비스, 레포지토리 등 정형화된 패턴의 경우 컴포넌트 스캔 방식이 더 자주 활용됨
- 외부 패키지 사용이나 구현 클래스의 변경이 필요한 경우, 직접 등록 방식을 활용
- 구현 클래스 변경 예제
  - Memory 사용 레포지토리에서 DB 사용 레포지토리로 변경해주세요!
  - 이 때, 직접 등록한 빈의 경우 해당 코드만 손 대주면 되기에 편리

</details>

</li>

</ul>

</details>

<!-- details 태그 구분을 위한 주석 -->

<hr />

    updated: 2024.01.06 (Mon)
