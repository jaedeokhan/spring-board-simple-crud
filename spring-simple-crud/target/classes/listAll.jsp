<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
    var result ='${msg}';
    
    if(result == '성공'){
        alert('게시판 등록에 '+ result+' 했습니다.');
    }
   
</script>
</head>
<body>
    <table class="table table-board" border="1px" width="80%" align="center">
        <tr>
            <th style="width:10%" >글 번호</th>
            <th style="width:30%">제목</th>
            <th style="width:20%">작성자</th>
            <th style="width:20%">날짜</th>
            <th style="width:20%">조회수</th>
        </tr>
 
 
    <c:forEach items="${boardList}" var="board">
        <tr>
            <td>${board.b_no }</td>
            <td><a href="/board/detail/${board.b_no}">${board.b_title}</a></td>
            <td>${board.b_writer }</td>
            <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${board.b_date }" /> </td>
            <td><span> ${board.b_count }</span> </td>
        </tr>
    </c:forEach>
    </table>
	
</body>
</html>