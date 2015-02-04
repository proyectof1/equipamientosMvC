<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		Integer valorId = (Integer) session.getAttribute("idRecurso");
	%>
	Esta usted seguro que quiere hacer la op. con el id = 
	<%
	out.println(valorId);	
	%>
	?
	
	<a href="./svPruebaSessionId">Ir a operacion</a>
	
</body>
</html>