<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	   <h2>${cList.boardNo}번 게시물 내용</h2>
    <p>
        # 작성자: ${cList.writer} <br>
        # 제목: ${cList.title} <br>
        # 내용: <textarea rows="5" readonly>${cList.content}</textarea> <br>
       			 <fmt:parseDate value="${cList.regDate}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both"/><br>
		# 작성시간:<fmt:formatDate value="${parsedDateTime}" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" /> <br>
    </p>
    
    <a href="<c:url value='/board/list'/>">글 목록 보기</a>
    <a href="<c:url value='/board/modify?boardNo=${cList.boardNo}'/>">글 수정 하기</a>
	
</body>
</html>