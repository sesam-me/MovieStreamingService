<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>ADMIN PAGE</title>
  <link rel="stylesheet" href="../style/reset.css">
  <link rel="stylesheet" href="../style/detail.css">
  <link rel="stylesheet" href="../style/login.css">
</head>
<body>
<%@include file="../layout/header.jsp"%>
  <div class="loginWrap">
  <div class="loginBox" style="padding-bottom: 5px">
    <h1>배우 추가</h1>
    <h2>Wavve 배우 추가하기</h2>

    <form class="inputWrap">
      <div class="inputInnerWrap" style="margin-bottom: 25px;">
        <input placeholder="배우 이름" />
        <input placeholder="배우 생년월일" />
        <input placeholder="배우 국적" />
        <input placeholder="배우 성별" />
      </div>

      <div class="loginBtnArea">
        <input type="submit" value="추가하기" />
      </div>

    </form>
  </div>
</div>
</body>
</html>
