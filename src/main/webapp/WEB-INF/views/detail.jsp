<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table class="table"
			style="text-align: center; border: 2px solid #dddddd">
			<thead style="border: 2px solid #dddddd;">
				<tr>
					<th colspan="3"
						style="background-color: #eeeeee; text-align: center;">게시판
						상세보기</th>
				</tr>
			</thead>
			<tbody style="border: 2px solid #dddddd;">
				<tr>
					<td style="width: 20%;">글 번호</td>
					<td colspan="2"><c:out value="${boardDetail.b_no}" />
					</td>
				</tr>
				<tr>
					<td style="width: 20%;">글 제목</td>
					<td colspan="2"><c:out value="${boardDetail.b_title}" />
					</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td colspan="2"><c:out value="${boardDetail.b_writer}" /></td>
				</tr>
				<tr>
					<td>작성일자</td>
					<td colspan="2"><c:out value="${boardDetail.b_date}" />
					</td>
				</tr>
				<tr>
					<td>조회수</td>
					<td colspan="2"><c:out value="${boardDetail.b_count}" />
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td colspan="2" style="min-height: 200px; text-align: left;"><c:out
							value="${boardDetail.b_detail}" /></td>
				</tr>
			</tbody>
		</table>
		<a href="/board/update/${b_no}">수정</a>
		<a href="/board/delete/${b_no}">삭제</a>
</body>
</html>