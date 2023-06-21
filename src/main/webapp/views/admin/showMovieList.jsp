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
    <div class="loginBox_admin">
        <h1 style="text-align: center; color: #fff; font-size: 24px; margin-bottom: 25px">어떤 영화에 출연진을 추가 하시겠어요 ?</h1>
<%--        <h1 style="text-align: center; color: #fff; font-size: 24px; margin-bottom: 25px">어떤 영화에 출연진을 삭제 하시겠어요 ?</h1>--%>
        <%
            for (int i = 0; i < 10; i++) {

            %>
        <div class="menu_item"><a href="/showActorList">범죄도시3</a></div>
        <%
            }
        %>
    </div>
</div>
</body>
</html>