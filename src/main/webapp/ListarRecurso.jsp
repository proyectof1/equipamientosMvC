
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="es.open4job.proyecto.model.vo.RecursosVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	RecursosVO recurso = (RecursosVO)request.getAttribute("lalala");
	//TicketVo tiq = request.getAttribute(“ticketlala”);
	out.println(recurso.getId());
	out.println(recurso.getTitulo());
	out.println(recurso.getLatitud());
	out.println(recurso.getLongitud());
%>
</body>
</html>