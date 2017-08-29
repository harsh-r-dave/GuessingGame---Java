<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script>
	$(document).ready(function() {
		var table = document.getElementById("gameTable");

		if (table != null) {
			for (var i = 0; i < table.rows.length; i++) {
				for (var j = 0; j < table.rows[i].cells.length; j++)
					table.rows[i].cells[j].onclick = function() {

						var guess = document.getElementsByName("guess")[0];
						guess.value = parseInt(this.innerHTML);
						document.getElementById("guess_submission").submit();

					};
			}
		}

	});
</script>

</head>
<body>


	
		<%
			//  Initialize.

			final HttpSession Sess = request.getSession();
			final String JustStarted = (String) Sess.getAttribute("JustStarted");
			final Integer No;
			final java.util.ArrayList Hist;
			int score=100;%>
		<% 
			if (JustStarted.equals("true")) {
				
				
				Integer Noo = new Integer(new java.util.Random().nextInt(101));
				if(Noo==0) No=1; else No=Noo;
				Hist = new ArrayList();

				Sess.setAttribute("no", No);
				Sess.setAttribute("hist", Hist);
				score = 100;
				Sess.setAttribute("JustStarted", "false");

			} else {

				No = (Integer) Sess.getAttribute("no");
				Hist = (java.util.ArrayList) Sess.getAttribute("hist");
			}

			//  Process the input.

			final String GuessStr = request.getParameter("guess");
			String GuessErrorMsg = null;
			int Guess = -1;

			if (!JustStarted.equals("true")) {
				score = (9-Hist.size())*10;
			    Sess.setAttribute("score", score);
				if (GuessStr != null && GuessStr.length() != 0) {

					try {

						Guess = Integer.parseInt(GuessStr);
						if (Guess < 0 || Guess > 100)
							GuessErrorMsg = "The guess must be in the range 0 to 100 (inclusive). " + "The number \""
									+ Guess + "\" is not in that range.";
						else
							Hist.add(new Integer(Guess));

					} catch (NumberFormatException e) {
						GuessErrorMsg = "The guess \"" + GuessStr + "\" is not a number.";
					}

				} else
					GuessErrorMsg = "The guess should be a number, but is blank.";
			}
		%>
		<div style="float: left;">User:<%=Sess.getAttribute("user")%></div>
		<div style="float: right;">Score:<%=score %></div>
		<h1 align="center">Number Guessing Game</h1>
		<div class='content'>
		<div border=1>
		<div align="center" >
		<table id="layout">
		<tr><td> 
		<table width="100%" id="gameTable" border="1" bgColor="#FFD581"
			style="cursor: pointer;">
			<%
				int k = 0;
				for (int i = 0; i < 10; i++) {
			%>
			<tr>
				<%
					for (int j = 0; j < 10; j++) {
							k++;
							
					if (Hist.size() > 0) {
						int PrevGuess,t=0;
						for (int Index = Hist.size() - 1; Index >= 0; Index--) {
							PrevGuess = (Integer) Hist.get(Index);
							if(PrevGuess == k)
							{
								t++;
								if(k<No)
								{
									%> <td bgcolor="#FFFF00""> <%
								}
								else if(k>No)
								{
									%> <td bgcolor="#0000FF""> <%
								}
								else
								{
									%> <td bgcolor="#00FF00""> <%
								}
							}
						}
						if(t==0)
						{

							%>
							<td>
							<%

						}
					}
					else
					{
						%>
						<td>
						<%
					}
					
				%><%=k%></td><% } %>
			</tr>
			<%
				}
			%>

		</table>
		<td>
		<td>
		
		<img height="250" width="200" src="http://192.168.43.9:8081/Group4_Proj2/ImageCapture?imagesize=<%=Hist.size()+1%>" alt="here comes the image">
		</td>
		</tr>
		</table>
		</div>
		</div>
		



		<%
			//  Produce the dynamic portions of the web page.

			if (Guess != No.intValue()) {
				if(Hist.size() < 10)
				{
		%>
		<div class='guess' style="position:relative;">
			
			<%
				if (GuessErrorMsg != null) {
			%>
			<div class='bad-field-error-message'><%=GuessErrorMsg%></div>
			<%
				}
			%>
			<form method='post' action="http://192.168.43.9:8081/Group4_Proj2/GGGame.jsp" id="guess_submission" onsubmit="update()">
				<label <%=GuessErrorMsg != null ? "class='bad-field'" : ""%>>
				<input type='hidden' size='6' name='guess'
					<%=GuessErrorMsg != null ? "value='" + GuessStr + "'" : ""%> />
				</label> <input type='submit' value='Guess' style="visibility:hidden;" />
			</form>
		</div>
		<%
				}
				else if(Hist.size() >= 10)
				{
					
					%>
					<div class='done' style="position:relative;">
						<p>
							Sorry! The number was
							<%=No%>. You didn't guess it right.
						</p>

						<form method='post' action="http://192.168.43.9:8081/Group4_Proj2/Home.jsp">
							<input type='submit' value='Go Home' />
						</form>
					</div>
					<%
					Sess.invalidate(); //  Destroy this session. We're done.
				}
			} 
			else{

				Sess.invalidate(); //  Destroy this session. We're done.
		%>
		<div class='done' style="position:relative;">
			<p>
				Correct! The number was
				<%=No%>. You guessed it in
				<%=Hist.size()%>
				attempts.
			</p>

			<form method='post' action="http://192.168.43.9:8081/Group4_Proj2/servletUpdateScore">
				<input type='submit' value='Play Again' />
			</form>
		
		<%
			}
		%>
		
		<div style="display: none;">
		<audio controls name="audio">
  <source src="http://192.168.43.9:8081/Group4_Proj2/MusicServlet" type="audio/mpeg" loop="true">
Your browser does not support the audio element.
</audio>
</div>

<script type="text/javascript">
function setCookie(c_name,value,exdays)
{
    var exdate=new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var c_value=escape(value) + ((exdays==null) ? "" : "; expires="+exdate.toUTCString());
    document.cookie=c_name + "=" + c_value;
}

function getCookie(c_name)
{
    var i,x,y,ARRcookies=document.cookie.split(";");
    for (i=0;i<ARRcookies.length;i++)
    {
      x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
      y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
      x=x.replace(/^\s+|\s+$/g,"");
      if (x==c_name)
        {
        return unescape(y);
        }
      }
}

var song = document.getElementsByName('audio')[0];
var played = false;
var tillPlayed = getCookie('timePlayed');
function update()
{
    if(!played){
        if(tillPlayed){
        song.currentTime = tillPlayed;
        song.play();
        played = true;
        }
        else {
                song.play();
                played = true;
        }
    }

    else {
    setCookie('timePlayed', song.currentTime);
    }
}

setInterval(update,1000);


document.onbeforeunload=update();
</script>
		
	
</body>
</html>