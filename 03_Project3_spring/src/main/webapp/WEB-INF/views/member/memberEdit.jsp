<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원 정보 수정</title>
<link rel="stylesheet" href="/css/base-style.css">
<link rel="stylesheet" href="/css/memberJoin.css">
<script type="text/javascript" src="/js/member.js"></script>
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

	<form action="/member/delete" method="get" id="form">
	</form>

		<div class="content">
			<h2>홍길동님 정보 수정</h2>
			<form action="/member/edit" method="post" id="edit_form">

				<div class="reg-frm">
					<div class="reg-line">
						<label for="id">아이디</label> <input type="text" id="id" name="id"
							value="${member.getId()}" readonly />
					</div>
					<div class="reg-line">
						<label for="name">이름</label> <input
							type="text" id="name" value="${member.getName()}" name="name"
							required>
					</div>	
					<div class="reg-line">
						<label for="new-password">새 비밀번호</label> <input type="password"
							id="pw" name="pw">
					</div>
					<div class="reg-line">
						<label for="cfmPw">새 비밀번호 확인</label> <input
							type="password" id="cfmPw" name="cfmPw">
					</div>
					<div class="reg-line">
						<label for="email">이메일</label> <input type="email" id="email"
							name="email" value="${member.getEmail()}">
					</div>
					<div class="reg-line">
						<label for="phone">전화번호</label> <input type="tel" id="phone"
							name="phoneNum" value="${member.getPhoneNum()}">
					</div>
					<div class="reg-line">
						<label for="address">주소</label> <input type="text" id="address"
							name="address" value="${member.getAddress()}">
					</div>
				</div>


				<div class="reg-btnn">
					<input type="button" id="delete-user" value="회원 탈퇴" onclick="deleteSubmit()">
					<input type="submit" id="modify-user" value="정보 수정" onclick="editSubmit()"> 
					<input type="button" id="reset" value="취소"
						onclick="window.location.href='/member/main?memberId=${userId}';">
				</div>
			</form>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/main/footer.jsp" flush="true"/>
</body>
</html>