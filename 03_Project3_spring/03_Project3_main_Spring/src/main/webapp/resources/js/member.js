function showAddressBookAlert() {
            alert('로그인 후 사용 가능합니다.');
}

function deleteSubmit() {
    var result = confirm("정말로 탈퇴 하시겠습니까?");
    if (result) {
        // 사용자가 "네"를 선택한 경우
        //alert("탈퇴 처리 되었습니다.");
        var form = document.getElementById("form");
        form.method = "get";
        form.action = "/member/delete?memberId=${userId}"; // 원하는 서블릿 경로 설정
        form.submit(); // 폼 제출
    } else {
        // 사용자가 "아니오"를 선택한 경우
        alert("취소하였습니다.");
    }
  
}

function doubleCheck() {
    var form = document.getElementById("join_form");
    var id = form.elements["id"].value;
    if (id.length < 4) {
	    alert('아이디를 4자 이상 입력하세요.');
	    join = false;
	    form.method = "post";
	    form.action = "/member/join"; // 원하는 서블릿 경로 설정
	    form.submit(); // 폼 제출
    } else{
	    form.method = "post";
	    form.action = "/member/doubleCheck"; // 원하는 서블릿 경로 설정
	    form.submit(); // 폼 제출
    }
}


function Validation(form) {    
    var id = form.elements["id"].value;
    var name = form.elements["name"].value;
    var pw = form.elements["pw"].value;
    var cfmPw = form.elements["cfmPw"].value;
    var join = true;

    if (id.length < 4) {
        alert('아이디를 4자 이상 입력하세요.');
        join = false;
    }

    if (!name.trim()) {
        alert("이름을 입력하세요.");
        join = false;
    }

    if (pw.length < 4) {
        alert("비밀번호를 4자 이상 입력하세요.");
        join = false;
    }

    if (pw != cfmPw) {
        alert("비밀번호와 확인 비밀번호가 일치하지 않습니다.");
        join = false;
    }

    return join;
}

function submitToServlet() {
    var form = document.getElementById("join_form");
    var name = form.elements["name"].value;
	console.log(name+'name')
	join = Validation(form);
    var idDoubleCheck = form.elements["idDoubleCheck"].value;
        
    if (idDoubleCheck != 'can') {
        alert("아이디 중복체크를 해주세요.");
        join = false;
    }
	
    if (join) {
		alert(name + '님! 가입을 축하합니다.');
        form.method = "post";
        form.action = "/member/joinOk"; // 원하는 서블릿 경로 설정
        form.submit();
    } else {
    	form.method = "post";
        form.action = "/member/join"; // 원하는 서블릿 경로 설정
        form.submit();
    }
}

function editSubmit() {
    var form = document.getElementById("edit_form");
	join = Validation(form);
	
    if (join) {
		alert('수정되었습니다.');
        form.method = "post";
        form.action = "/member/editOk"; // 원하는 서블릿 경로 설정
        form.submit();
    } else {
    	form.method = "post";
        form.action = "/member/edit"; // 원하는 서블릿 경로 설정
        form.submit();
    }
}
