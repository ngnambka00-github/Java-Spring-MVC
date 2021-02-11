<%@page import="java.util.List"%>
<%@page import="com.ngnam.entity.SinhVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Object</title>
</head>
<body>
	<h1>${ sinhVien.getTenSinhVien() }</h1>
	<h1>${ sinhVien.getMSSV() }</h1>
	<h1>${ sinhVien.getDiemTT() }</h1>
	
	
	<%
		SinhVien sv = (SinhVien)request.getAttribute("sinhVien");
	%>
	<h1>Sử dụng Scriptlet Tag và Expression tag</h1>
	<h1>Tên sinh viên: <%= sv.getTenSinhVien() %></h1>
	<h1>MSSV: <%= sv.getMSSV() %></h1>
	<h1>Điểm trung bình: <%= sv.getDiemTT() %></h1>
	
	
	<!-- Trường hơp ví dụ với List -->
	<%
		List<SinhVien> listSinhVien = (List<SinhVien>)request.getAttribute("listSV");
		for (SinhVien itemSV : listSinhVien) {
	%>
	
	<h2> <%= itemSV.getTenSinhVien() %></h2>
	
	<%} %>
	
</body>
</html>