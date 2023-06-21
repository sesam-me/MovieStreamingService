<%@page contentType="text/html;charset=UTF-8" language="java" %>

<header>
  <div class="header_nav">
    <div class="header_top_wrap">
      <div></div>
      <ul>


        <%
          if(session.getAttribute("useq") != null) {
            %>
<%--    #### href른 doget이 디폴트임.--%>
<%--    <form class="inputWrap" action="/login" method="post"> 이렇게 method="post"로 보낸다면 dopost사용--%>
        <li><a href="/logout">로그아웃</a></li>
        <% } else {
        %>
        <li><a href="/login">로그인</a></li>
        <% } %>


        <li><a href="/signup">회원가입</a></li>


        <li><a href="/adminMenu">관리자메뉴</a></li>




      </ul>
    </div>
  </div>
  <div class="main_menu">
    <div class="header_bot_wrap">
      <div class="header_left_section">
        <div class="logo">
          <a href="/">
            <img style="height: 30px; cursor: pointer" src="../img/Mavve.png" />
          </a>
        </div>
        <ul>
          <li><a href="/main">홈</a><li>
          <li><a>카테고리</a><li>
          <li><a>LIVE</a><li>
          <li><a href="/edit">MY</a><li>
        </ul>
      </div>
      <div class="search_section"></div>
    </div>
  </div>
</header>