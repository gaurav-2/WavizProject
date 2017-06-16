<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
<form action="home" method="get">
<table>
        <tr>
			<td><label for="">Full Name</label></td>
			<td><input name="name" type="text"></td>
		</tr>
		<tr>
			<td><label for="">Mobile No</label></td>
			<td><input name="mobile" type="text"></td>
		</tr>
		<tr>
			<td><label for="">Email id</label></td>
			<td><input name="mail" type="text"></td>
		</tr>
		<tr>
			<td><label for="">Password</label></td>
			<td><input name="pass" type="password"></td>
		</tr>
		<tr>
			<td><label for="">Confirm Password</label></td>
			<td><input name="repass" type="password"></td>
		</tr>
		<tr>
			<td><label for="">Address</label></td>
			<td><textarea rows="3" cols="20" name="add"></textarea> </td>
		</tr>
		<tr>
			<td><label for="">Hobbies</label>
			<td><input type="checkbox" name="hobby" value="Singing">Singing<br>
			<input type="checkbox" name="hobby" value="Reading">Reading<br>
			<input type="checkbox" name="hobby" value="Travelling">Travelling<br></td>
			<td><input type="checkbox" name="hobby" value="playing">playing<br>
			<input type="checkbox" name="hobby" value="Surfing">Surfing<br>
			<input type="checkbox" name="hobby" value="TV">Watching Tv</td>
		</tr>
		
		<tr>
	        <td><label for="">Gender</label></td>
	        	
	       <td> <input type="radio" name="gender" value="male" checked> Male<br>
            <input type="radio" name="gender" value="female"> Female</td>
	    </tr>
	    <tr>
	        <td><input type="submit" name="submit" value="Sign Up" align="middle"> </td>
	    </tr>
		
</table>
</form>
</body>
</html>