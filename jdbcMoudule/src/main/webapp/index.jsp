<%@page import="DBUtil.MysqlData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,studentData.*,DBUtil.MysqlData,service.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<jsp:useBean id="mysqlDataSelect" class = "DBUtil.MysqlData"></jsp:useBean>
<%
	Student student = new Student();
	student.setsid(4);
	student.setname("xiaohong");
	student.setage(26);
	student.setgrade("six");
	mysqlDataSelect.update(student);
	mysqlDataSelect.delete("xiaofeng");
	List<Student> list = mysqlDataSelect.selectAll();
%>
<table>
	<tr>
		<th>学号</th>
		<th>姓名</th>
		<th>年龄</th>
		<th>年级</th>
	</tr>
	<%
		for (int i = 0; i < list.size(); i++) {
	%>

	<tr>
		<td><%=list.get(i).getsid()%></td>
		<td><%=list.get(i).getname()%></td>
		<td><%=list.get(i).getage()%></td>
		<td><%=list.get(i).getgrade()%></td>
	</tr>
	<%
		}
	%>
</table>

</body>
</html>
