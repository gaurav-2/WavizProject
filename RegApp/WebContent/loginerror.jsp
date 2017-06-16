<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<table>
<tr>
<td>
<%-- <jsp:include page="loginerror.jsp"/> --%>
<form action="login" method="post"></form>
<%@include file="login.jsp"%>
</td>
</tr>
<tr>
<td><label for="">Captcha</label>
<%= request.getAttribute("captcha") %></td>

</tr>
<tr>
			<td><label for="">Enter Captcha</label>
			<input name="captcha" type="text"></td>
</tr>

</form>