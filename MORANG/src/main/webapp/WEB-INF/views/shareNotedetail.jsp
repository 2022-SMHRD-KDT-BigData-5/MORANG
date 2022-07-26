<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.smhrd.domain.shareNote"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="resources/css/noteshare.css">
<script src="https://kit.fontawesome.com/3e55fa4950.js"
	crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Dongle&display=swap"
	rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<!-- 차트 js -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- 자바 스크립트 -->


    <script type="text/javascript">
	function goList(){
		location.href = "/web/shareNote.do";
	}		
	
	function goDelete(note_seq){
		
		location.href = '/web/shareNoteDelete.do?note_seq=' + note_seq;
		
	}
	
	function goUpdate(note_seq){
		location.href = "/web/shareNoteGoUpdate.do?note_seq=" + note_seq;
	}

	
</script>
</head>
<body>
	<nav class="navbar">
		<div class="navbar_logo">
			<i class="fa-thin fa-hands-holding-child"></i> <a href="메인 페이지.html">MoRang.</a>
		</div>

		<ul class="navbar_menu">
			<li><a href="">개인정보수정</a></li>
			<li><a href="">로그아웃</a></li>
		</ul>
	</nav>
	<div class="app">
		<div class="menu-toggle">
			<div class="hamburger">
				<span></span>
			</div>
		</div>
		<nav class="sidebar">
			<div class="toggle-btn">
				<span></span> <span></span> <span></span>
			</div>

			<h1>Menu</h1>
			<nav class="menu">
				<a href="메인 페이지.html" class="menu-item">HOME</a> <a
					href="산전 우울증.html" class="menu-item">우울증 자가진단</a> <a
					href="감정일기장.html" class="menu-item">감정 일기장</a> <a href="공유수첩.html"
					class="menu-item">공유수첩</a> <a href="게시판.html" class="menu-item">게시판</a>
			</nav>
		</nav>

		<div class="share_note">

			<div class="share_note_detail">
				<div class="share_title">${requestScope.shareNote.note_title}</div>
				<% pageContext.setAttribute("newLine", "\n"); %>
				<div class="share_content">
				${fn:replace(shareNote.note_content, newLine, "<br>") }
				</div>
					
				<div class="share_btn">
					<button onclick="goUpdate(${shareNote.note_seq})">수정</button>
					<button onclick="goDelete(${shareNote.note_seq})">삭제</button>
					<button onclick="goList()">돌아가기</button>
				</div>
			</div>

		</div>






	</div>
</body>
</html>