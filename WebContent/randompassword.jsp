<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@page import = "java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%String pass; %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-1.9.1.min.js" ></script>
<script>
$(document).ready(function(){
	var table = document.getElementById("gameTable");
	var password;
	var pass = [];
    if (table != null) {
        for (var i = 0; i < table.rows.length; i++) {
            for (var j = 0; j < table.rows[i].cells.length; j++)
            table.rows[i].cells[j].onclick = function () {
                alert(this.innerHTML);
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

</head>
<body>
<input type="text" name="t1">
<input type="submit" name="password" value="PassWord" text="Submit Password">
<TABLE id="gameTable" cellpadding="15" border="1" style="background-color: #ffffcc;">
<%
final int[] array = new Random().ints(0, 10).distinct().limit(10).toArray();
%>
<TR>
<TD><%=array[0]  %></TD>
<TD><%=array[1]%></TD>
<TD><%=array[2]%></TD>
<TD><%=array[3]%></TD>
<TD><%=array[4]%></TD>
</TR>
<TR>
<TD><%=array[5]  %></TD>
<TD><%=array[6]%></TD>
<TD><%=array[7]%></TD>
<TD><%=array[8]%></TD>
<TD><%=array[9]%></TD>
</TR>
</TABLE>
<label id = "lb"  ><b></b></label>
</body>
</html>