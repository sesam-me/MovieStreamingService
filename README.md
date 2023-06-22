# MovieStreamingService
이전에 콘솔로만 결과를 확인하였는데 웹을 통해 화면으로 볼 수 있게 하였습니다.
스트리밍사이트 Wavve웹 페이지를 클론코딩하였습니다.

## Index



## Technology
<h4>fornt</h4>
JSP CSS Swiper.js
<h4>back</h4>
Java 8 Servlet MySql ChatGPT JDBC Tomcat

## Contents
기간 : 2023.20.-2023.06.23 <br/>
내용 : 영화 스트리밍 사이트 구현(일반인 모드, 관리자 모드)



## ERD
영화, 사용자, 리뷰 테이블 중 영화, 사용자 테이블만 구현
(리뷰 추후 구현)
<img src="https://github.com/sesam-me/PlayData_BootCamp/assets/122416681/c76aa14a-d5c2-4ca2-8a25-a3abc5f7b410"  width="700" height="370"> <br/>
[ERD링크](https://www.erdcloud.com/d/Zjxy3xfjEpDhucjbk)


## Contributing
<details>
<summary>1. 로그인/로그아웃</summary>
<div markdown="1">
  
    1-1. id와 email 중 선택하여 로그인 가능<br/>
    1-2. 아이디 저장<br/>
          - 아이디 저장 체크 후에는 계속해서 체크박스 체크 상태 유지<br/>
          - 아이디 저장 체크 해체 후에는 계속해서 체크박스 해체 상태 유지<br/>
    1-3. 로그인 성공 후, head부분 로그인 버튼에서 로그아웃 버튼으로 변경<br/>
    1-4. 로그인 성공 후에만, MY페이지에서 회원정보 확인 및 수정 가능 / 실패 시, 로그인 화면으로 이동<br/>
    1-5. 관리자 외 접속 제한 : 관리자 계정 로그인 성공 시에만, 관리자 페이지 버튼 생성<br/>
    1-6. 로그아웃<br/>

</div>
</details>

<details>
<summary>2. 영화 추천</summary>
<div markdown="1"> 
  
- 장르별 영화 추천
</div>
</details>


## Description
**function**

<ol>
  <li>로그인/로그아웃</li>
  <li>회원가입</li>
  <li>정보수정</li>
  <li>아이디 찾기, 비밀번호 재설정</li>
  <li>admin 메뉴 영화 추가</li>
  <li>admin 메뉴 배우 추가</li>
  <li>admin 메뉴 영화 출연진 추가</li>
  <li>ChatGpt를 이용한 AI에게 영화 추천 받기</li>
</ol>


## Feature Implementation

| Main         | Login         |
| ------------ | ------------- |
| <img src = "https://github.com/sesam-me/HTML_lesson/assets/122416681/8136e9a1-42f1-4b52-a773-b2e82bc9a903" | Content Cell  |









[맨위로 올라가기](#)
