<div align="center">
    
    ![SLR로고](./images/Logo_Blue2.png)
    
</div>

---

## Class Review Site Server
> 수업 리뷰 사이트는 대학생들이 직접 들은 수업을 바탕으로 리뷰를 작성하고 공유하는 시스템입니다.

### Skills
* Java 17
* Spring Boot 3.2.5
* JPA
* MySql

### Naming
* Lecture : 강의 고유 정보
* ClassList : 개설된 강의
* User : 사용자 (학생, 교수)
* Review : 수강후기
* Auth : 인증

### Features
* 학과 전체 조회
* 수강 후기 작성 요청
* 수강 후기 수정 요청
* 수강 후기 삭제 요청
* 수강 후기 상세 조회 요청
* 수강 후기 전체 조회
* 학생 회원 가입
* 학생 로그인

### Swagger

* localhost:8000/swagger-ui/index.html 접속 후 사용

### API 구조

![image](https://github.com/user-attachments/assets/ee5e16c7-d28f-4531-b729-94dbb8beceea)

### 구현 및 추가 설명

- API 서버 코드 작성 후 배포 및 리팩토링
    - spring security의 userpasswordtoken을 사용해 토큰 인증 방식 로그인 기능 작성
    - 해당 유저가 학생, 교수를 판단하기위해 userAuthority 테이블에 해당 계정을 명시
    - 예외처리를 위해서 ControllerAdvice 클래스를 작성
    - 개설된 강의(Class)와 순수 강의 정보(Lecture)을 분리하여 해당 강의를 가르치는 교수가 변경되어도 기존의 강의정보를 활용할 수 있도록 작성
    - 학생이 어떤 강의를 들었는지 이수구분 데이터를 저장하여 관리할 수 있도록 UserClassList 작성
    - 정적 팩토리 메서드 패턴을 활용하여 builder 패턴의 중복을 최소화
    - 요청에 대한 응답 form을 순수 제너릭 클래스 타입(T)로 명시하여 캡슐화

- 데이터베이스 모델 설계 및 제작
    - 수강 후기 데이터들을 모아놓기 위한 도메인 네이밍 및 관계를 구상
    - 후에 데이터베이스를 분산 처리를 진행해도 문제없도록 알맞는 정규화를 진행
