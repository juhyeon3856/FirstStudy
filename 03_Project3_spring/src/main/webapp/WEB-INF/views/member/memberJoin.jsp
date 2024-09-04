<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>
<link rel="stylesheet" href="/css/base-style.css">
<link rel="stylesheet" href="/css/memberJoin.css">
<script type="text/javascript" src="/js/member.js"></script>
</head>
<body>
	<c:set var="idDoubleCheck" value="${memberPw}" />
	<c:if test="${idDoubleCheck == 'can'}">
	    <script>
	        alert('사용 가능한 아이디입니다.');
	    </script>
	    <c:set var="inputId" value="${member.getId()}" />
	</c:if>
	<c:if test="${not empty idDoubleCheck and  idDoubleCheck != 'can' and  idDoubleCheck != ''}">
	    <script>
	    	${idDoubleCheck = null}
	        alert('사용 불가능한 아이디입니다.');
	    </script>
	    <c:set var="inputId" value="" />
	</c:if>
	
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
		<div class="contentt">
			<form action="#" class="join" method="post" id="join_form">
				<div class="title">
				<h2>회원가입</h2>
				</div>
				<div class="reg-frm">
					<div class="reg-line">
						<label for="name">이름</label> 
						<input type="text" id="name"
							name="name" required value="${member.getName()}"
							placeholder="  이름을 입력하세요." />
					</div>
					<div class="reg-line">
						<label for="id">아이디</label>
						<input type="text" id="id" name="id" required
									value="${inputId}"
									placeholder="  아이디를 입력하세요. (4자 이상)" />
					</div>
					<div class="reg-line cfm-id" id="cfm-id">
						<input type="button" value="중복 확인"
							onclick="doubleCheck()"></input>
					</div>
					<div class="reg-line">
						<label for="pw">비밀번호</label> <input type="password" id="pw"
							required name="pw" value="${member.getPw()}"
							placeholder="  비밀번호는 영문+숫자+특수문자의 조합입니다." />
					</div>
					<div class="reg-line">
						<label for="cfm-pw">비밀번호 확인</label> 
						<input type="password"
							id="cfm-pw" name=cfmPw value="${cfmPw}"
							placeholder="  비밀번호를 다시 입력하세요." />
					</div>
					<div class="reg-line">
						<label for="email">이메일</label> 
						<input type="email" id="email"
							name="email" value="${member.getEmail()}"
							placeholder="  이메일을 입력하세요." />
					</div>
					<div class="reg-line">
						<label for="phone">전화번호</label> 
						<input type="text" id="phone"
							name="phoneNum" value="${member.getPhoneNum()}"
							placeholder="  전화번호를 입력하세요. (010-0000-0000)" />
					</div>
					<div class="reg-line">
						<label for="address">주소</label> <input type="text" id="address"
							name="address" value="${member.getAddress()}"
							placeholder="  주소를 입력하세요." />
					</div>
				</div>
				<div class="reg-btnn">
					<input type="button" value="회원가입"	onclick="submitToServlet()">
					<input type="button" value="취소"	 onclick="window.location.href='/member';">
				</div>
				<input type="hidden" name="idDoubleCheck" value="${idDoubleCheck}" />
			</form>

		</div>
		</div>
		
	</div>

	<jsp:include page="/WEB-INF/views/main/footer.jsp" flush="true"/>
</body>
</html>