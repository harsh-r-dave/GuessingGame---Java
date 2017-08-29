<%@page import="ggHelperJsp.GGHelper"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<% 
	int remainingChance, score, randomNumber, userNumber = 0;
	GGHelper ggh = new GGHelper();
	ggh.setRandomNumber();
	randomNumber = ggh.getRandomNumber(); %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Group 4 Project 2</title>
<script type="text/javascript">
$(document).ready(function(){
function gamePlay() {
	var a = document.getElementById(user_number).value;
	alert(a);
	alert(<%=randomNumber%>);
}
});
</script>
</head>
<body>
	<h2>Welcome to the Guessing the Number game</h2>
	<form action="JspHelperServlet" method="get">
		Select song: <input type="file" name="file_path">
		<input type="submit" name="play_music" value="PlayMusic" text="Play Music">
		<input type="submit" name="stop_music" value="StopMusic" text="Stop Music"><br><br>
		
		
		<label>Enter your guess: <input type="text" id="user_number" name="user_number"></label>
		<input type="button" name="check" value="Check" text="Check" onClick="gamePlay()" />
	</form>
</body>
</html>