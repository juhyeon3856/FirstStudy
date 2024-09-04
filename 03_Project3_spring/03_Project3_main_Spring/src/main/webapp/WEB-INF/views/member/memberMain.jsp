<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원 정보</title>
<link rel="stylesheet" href="/css/base-style.css">
<link rel="stylesheet" href="/css/memberJoin.css">
</head>
<body>
    <c:choose>
        <c:when test="${isLoggedIn == true}">
            <jsp:include page="/WEB-INF/views/main/headerOUT.jsp" flush="true"/>
        </c:when>
        <c:otherwise>
            <jsp:include page="/WEB-INF/views/main/headerIN.jsp" flush="true"/>
        </c:otherwise>
    </c:choose>

    <div class="container">
      <c:choose>
        <c:when test="${isLoggedIn == true}">
            <jsp:include page="/WEB-INF/views/main/side.jsp" flush="true"/>
        </c:when>
       </c:choose>



		<div class="content">
			<div class="content__list">
				<h1>${member.getName()}님의 회원정보</h1>
				<div class="reg-line">
					<label>아이디 </label>
					<input type="text"
						value="${member.getId()}" disabled>
				</div>
				<div class="reg-line">
					<label>이메일</label> <input type="email"
						value="${member.getEmail()}" disabled>
				</div>
				<div class="reg-line">
					<label>연락처</label> <input type="text"
						value="${member.getPhoneNum()}" disabled>
				</div>

				<div class="reg-line">
					<label>주소</label> <input type="text"
						value="${member.getAddress()}" disabled>
				</div>
				<div class="reg-btnn">
				<input type="submit" value="수정" onclick="window.location.href='/member/pwCheck';"> 
				<input type="button" class="btn" value="내글 보기" >
					</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/main/footer.jsp" flush="true"/>
</body>
</html>