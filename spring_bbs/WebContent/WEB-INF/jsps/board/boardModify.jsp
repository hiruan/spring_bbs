<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<title>게시판 수정 폼</title>
<script type="text/javascript" src="<c:url value="/ckeditor/ckeditor.js" />"></script>
<style type="text/css">
	* {font-size: 9pt;}
	p {width: 600px; text-align: right;}
	table tbody tr th {background-color: gray;}
</style>
<script type="text/javascript">
	function goUrl(url) {
		location.href=url;
	}
	// 수정 폼 체크
	function boardModifyCheck() {
		var form = document.boardModifyForm;
		if (form.subject.value == '') {
			alert('제목을 입력하세요.');
			form.subject.focus();
			return false;
		}
		if (form.writer.value == '') {
			alert('작성자을 입력하세요');
			form.writer.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<form name="boardModifyForm" action="<c:url value="boardModify" />" method="post" onsubmit="return boardModifyCheck();">
	<input type="hidden" name="num" value="<c:out value="${boardVo.num}" />" />
	<input type="hidden" name="pageNum" value="<c:out value="${boardVo.pageNum}" />" />
	<input type="hidden" name="searchType" value="<c:out value="${boardVo.searchType}" />" />
	<input type="hidden" name="searchText" value="<c:out value="${boardVo.searchText}" />" />
	<table border="1" summary="게시판 수정 폼">
		<caption>게시판 수정 폼</caption>
		<colgroup>
			<col width="100" />
			<col width="500" />
		</colgroup>
		<tbody>
			<tr>
				<th align="center">제목</th>
				<td><input type="text" name="subject" size="80" maxlength="100" value="<c:out value="${boardVo.subject}" />" /></td>
			</tr>
			<tr>
				<th align="center">작성자</th>
				<td><input type="text" name="writer" maxlength="20" value="<c:out value="${boardVo.writer}" />" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea name="contents" cols="80" rows="10"><c:out value="${boardVo.contents}" escapeXml="false" /></textarea>
					<script>
					CKEDITOR.replace('contents');
					</script>
				</td>
			</tr>
		</tbody>
	</table>
	<p>
		<input type="button" value="목록" onclick="goUrl('<c:url value="boardList?pageNum=${boardVo.pageNum}&amp;searchType=${boardVo.searchType}&amp;searchText=${boardVo.searchText}" />');" />
		<input type="submit" value="글수정" />
	</p>
	</form>
	spring 게시판
</body>
</html>