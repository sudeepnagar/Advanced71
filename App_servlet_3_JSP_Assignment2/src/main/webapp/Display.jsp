<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  String Sroll=request.getParameter("sroll");
  String Sname=request.getParameter("sname");
  String Sbranch=request.getParameter("sbranch");
  int Spm=Integer.parseInt(request.getParameter("sphmarks"));
  int Scm=Integer.parseInt(request.getParameter("schmarks"));
  int Smm=Integer.parseInt(request.getParameter("smmarks"));
  int Stotmarks=Spm+Scm+Smm;
  float Sper=(float)Stotmarks/3;
  String Sres=Sper>=40?"Pass":"Fail";

  out.println("*********Student Details***********"+"<br>");
  out.println("Student Roll no:"+Sroll+"<br>");
  out.println("Student Name:"+Sname+"<br>");
  out.println("Student Branch:"+Sbranch+"<br>");
  out.println("Student Physics Marks:"+Spm+"<br>");
  out.println("Student Chemistry Marks:"+Scm+"<br>");
  out.println("Student Maths Marks:"+Smm+"<br>");
  out.println("Student Total Marks:"+Stotmarks+"<br>");
  out.println("Student Percentage:"+Sper+"<br>");
  out.println("Student Result:"+Sres+"<br>");
%>
</body>
</html>