<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jiujiu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1>九九乘法口诀表</h1>
    <hr>
    <table>
    <%for(int i=1;i<=9;i++){ %>
    <tr>
	    <%for(int j=1;j<=i;j++){ %>
		    <td width='70px'>
		    <%=j+"*"+i+"="+j*i%>
		    </td>
	    <%} %>
    </tr>
    <%} %>
    </table>
  </body>
</html>
