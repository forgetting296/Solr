<%@ page import="com.opensymphony.xwork2.interceptor.ExceptionHolder" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:debug/>
	<%
	//取出值栈中的栈顶对象
	ExceptionHolder eh = (ExceptionHolder)ActionContext.getContext().getValueStack().pop();
	//取出异常对象
	Exception e = eh.getException();
	//判断
	if(e instanceof org.apache.shiro.authc.UnknownAccountException){
		out.write("用户名错误");
	}else if(e instanceof org.apache.shiro.authc.IncorrectCredentialsException){
		out.write("密码错误");
	}else{
		out.write("您操作有误");
	}
	%>
	<!--出现了错误！！！！--><!--  -->
</body>
</html>