<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/bigdataShop/common/css/jqcloud.css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.js"></script>
<script type="text/javascript" src="/bigdataShop/common/js/jqcloud-1.0.4.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>

<body>
	<table class="table table-bordered" style="width: 30%;float:left;">
		<thead>
			<tr>
				<th>단어</th>
				<th>갯수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="comment" items="${wordlist}">

				<tr>
					<td>${comment.word}</td>
					<td>${comment.count}</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
	
	<div id="cloudword" style="width: 70%;height: 350px;float:left;"></div>
	
	<script>
		
	    var arr2 = new Array();
	    <c:forEach items="${cloudlist}" var="cloud">
	    arr2.push({text:"${cloud.word}",weight:"${cloud.count}"});
	    </c:forEach>
	    
		$(function() {
			// When DOM is ready, select the container element and call the jQCloud method, passing the array of words as the first argument.
			$("#cloudword").jQCloud(arr2);
		}); 
		
		
	</script>
</body>
</html>