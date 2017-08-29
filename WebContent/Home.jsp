<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@page import = "java.util.Collection"%>

<%
			//  Initialize.

			final HttpSession Sess = request.getSession();
			boolean flag;

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.disabled {
   pointer-events: none;
   cursor: default;
}
</style>



</head>
<body>
<script  src="http://code.jquery.com/jquery-1.9.1.min.js" ></script>
<script>
$(document).ready(function(){
	//alert("Hello all");
	var table = document.getElementById("logintable");
	var password;
	var pass = [];
    if (table != null) {
        for (var i = 0; i < table.rows.length; i++) {
            for (var j = 0; j < table.rows[i].cells.length; j++)
            table.rows[i].cells[j].onclick = function () {
               // alert(this.innerHTML);
                var no = this.innerHTML;
                pass[i] = no;
                //password = StringBuilder().append(password).append(no).toString();
              //  document.getElementById("lb").value = password;
                var guess = document.getElementsByName("t1")[0];
				guess.value = guess.value + no;
            }
        }
    }
});
</script>

	<table id="home_layout" border="1">
		<tr>
			<td colspan="3"><img src="Capture.PNG" alt="404-image not found"
				height=270 width=750></td>
			<td><img src="Capture-1.PNG" alt="404-image not found"
				height=270 width=270></td>
		</tr>
		<tr>
			<form id="login" action="http://192.168.43.9:8081/Group4_Proj2/servletLogin" method="post">
				
				<td align="center"><label for="user_name">Username</label>
					<input type="text" id="user_name" name="user_name"/><br>
					<label for="">Password</label><input type="text" name="t1" readonly/>
				<TABLE id="logintable" cellpadding="15" border="1"
						style="background-color: #ffffcc;">
						<%
							final int[] array = new Random().ints(0, 10).distinct().limit(10).toArray();
						%>
						<TR>
							<TD><%=array[0]%></TD>
							<TD><%=array[1]%></TD>
							<TD><%=array[2]%></TD>
							<TD><%=array[3]%></TD>
							<TD><%=array[4]%></TD>
						</TR>
						<TR>
							<TD><%=array[5]%></TD>
							<TD><%=array[6]%></TD>
							<TD><%=array[7]%></TD>
							<TD><%=array[8]%></TD>
							<TD><%=array[9]%></TD>
						</TR>
					</TABLE> <label id="lb"><b></b></label></td>	
					
					
				</td>
				<td align="center"><input type="submit" name="password"
					value="Login" text="Submit Password" style="height: 50px; width: 100px">
					
				<td colspan="2" align="center"><input type="button" value="Click here to register"
					 onclick="location.href='http://192.168.43.9:8081/Group4_Proj2/registration.html';" style="height: 50px; width: 300px" />
				</td>
			</form>
		</tr>
		<%
		try{
		String name= (String) Sess.getAttribute("user");
		flag = false;
		}
		catch(Exception e)
		{
			flag=true;
		}
		if(flag)
		{
		%>
		
		<tr>
			<td><a href="GGGame.jsp" class = "disabled"> <img src="Capture-2.PNG"
					alt="404-image not found" height=200 width=320>
			</a></td>
			<td><img src="Capture-5.PNG" alt="404-image not found"
				height=200 width=190 class = "disabled"></td>
			<td><img src="Capture-6.PNG" alt="404-image not found"
				height=200 width=190 class = "disabled"></td>
			<td><img src="Capture-3.PNG" alt="404-image not found"
				height=200 width=250 class = "disabled"></td>
		</tr>
		<% 
		}
		else
		{
		%>
		<tr>
			<td><a href="GGGame.jsp" > <img src="Capture-2.PNG"
					alt="404-image not found" height=200 width=320>
			</a></td>
			<td><img src="Capture-5.PNG" alt="404-image not found"
				height=200 width=190 ></a></td>
			<td><img src="Capture-6.PNG" alt="404-image not found"
				height=200 width=190 ></td>
			<td><img src="Capture-3.PNG" alt="404-image not found"
				height=200 width=250 ></td>
		</tr>
		
		<% 
		Sess.setAttribute("JustStarted", "true");
		}
		%>
	</table>
</body>
</html>