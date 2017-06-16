<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<table>
<tr>
<td>
<%-- <jsp:include page="loginerror.jsp"/> --%>
<%@include file="login.jsp"%>
</td>
</tr>
<tr>

<td><%= request.getAttribute("captcha") %></td>

</tr>
<tr>
			<td><label for="">Enter Captcha</label></td>
			<td><input name="captcha" type="text"></td>
</tr>

</table>