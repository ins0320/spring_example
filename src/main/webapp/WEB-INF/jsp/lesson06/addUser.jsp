<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>

<!-- bootstrap CDN link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<%-- AJAX를 사용하려면 jquery 원본 필요 --%>
 <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<h1>회원가입</h1>
		
		<form method="post" action="/lesson06/ex01/add-user">
			<div class="form-group">
				<label for="name">이름</label>
				<input type="text" id="name" name="name" class="form-control col-4">
			</div>
			<div class="form-group">
				<label for="yyyymmdd">생년월일</label>
				<input type="text" id="yyyymmdd" name="yyyymmdd" class="form-control col-4" placeholder="예) 19991201">
			</div>
			<div class="form-group">
				<label for="email">이메일</label>
				<input type="text" id="email" name="email" class="form-control col-4">
			</div>
			<div class="form-group">
				<label for="introduce">자기소개</label>
				<textarea id="introduce" name="introduce" class="form-control"></textarea>
			</div>
			<%-- AJAX로 할 때는 submit이 되면 안되므로 button으로 변경 --%>
			<!-- <input type="submit" class="btn btn-success" value="추가"> -->
			<button type="button" class="btn btn-success" id="addBtn" >회원가입</button>
		</form>
	</div>
	
<script>
$(document).ready(function() {

/* 	$("form").on("submit", function(e) {
		
		var name = $("#name").val().trim(); // 공백제거 
		if(name.length < 1) {
			alert("이름을 입력해주세요.");
			return false;
		}
		
		var yyyymmdd = $('#yyyymmdd').val().trim();
		if (yyyymmdd.length < 1) {
			alert("생년월일을 입력해주세요.");
			return false;
		}
		
		
		return true;
	
	}); */
	
	$("#addBtn").on("click", function() {
		// validation 
		var name = $("#name").val();
		var yyyymmdd = $('#yyyymmdd').val();
		var email = $('#email').val();
		var introduce = $('#introduce').val();
		if(name.length < 1) {
			alert("이름을 입력해주세요.");
			return ;
		}
		
		if (yyyymmdd.length < 1) {
			alert("생년월일을 입력해주세요.");
			return ;
		}
		
		
		if(email.length < 1) {
			alert("이메일을 입력해 주세요.");
			return ;
		}
		
		// AJAX: 비동기로 서버에 요청 
		$.ajax({
			// request
			type:"POST"
			, url:"/lesson06/ex01/add-user"
			, data:{"name":name, "yyyymmdd":yyyymmdd,"email":email, "introduce":introduce}
			
			// response
			, success:function(data){ // call back 함수. data param: 응답값
				alert(data); // "성공"
				if(data == "성공"){	
					location.href="/lesson06/ex01/after-add-user-view"; // GET 요청(화면 이동)
				}
			}
			, error: function(request, status, error){
				alert(request);
				alert(status);
				alert(error);
			}
			
			//앞으로는 사용 안함
			, complete:function(data){
				alert("성공이든 실패든 완료");
			}
			
		}); // -- ajax의 끝		
	}); // -- 클릭이벤트 끝		
}); // -- ready 함수 끝
</script>	
</body>
</html>