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
	<h1>Number Guessing Game</h1>

	<div class='content'>
		<%
			//  Initialize.

			final HttpSession Sess = request.getSession();
			final boolean JustStarted = Sess.isNew();
			final Integer No;
			final java.util.ArrayList Hist; %>
		<% 
			if (JustStarted) {
				
				
				Integer Noo = new Integer(new java.util.Random().nextInt(101));
				if(Noo==0) No=1; else No=Noo;
				Hist = new ArrayList();

				Sess.setAttribute("no", No);
				Sess.setAttribute("hist", Hist);

			} else {

				No = (Integer) Sess.getAttribute("no");
				Hist = (java.util.ArrayList) Sess.getAttribute("hist");
			}

			//  Process the input.

			final String GuessStr = request.getParameter("guess");
			String GuessErrorMsg = null;
			int Guess = -1;

			if (!JustStarted) {

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
		
		<img height="250" width="200" src="http://192.168.0.17:8081/Group4_Proj2/ImageCapture?imagesize=<%=Hist.size()+1%>" alt="here comes the image">
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
			<p>A random number between 0 and 100 (inclusive) has been
				selected.</p>
			<%
				if (GuessErrorMsg != null) {
			%>
			<div class='bad-field-error-message'><%=GuessErrorMsg%></div>
			<%
				}
			%>
			<form method='post' id="guess_submission" onsubmit="update()">
				<label <%=GuessErrorMsg != null ? "class='bad-field'" : ""%>>Guess
					the number: <input type='text' size='6' name='guess'
					<%=GuessErrorMsg != null ? "value='" + GuessStr + "'" : ""%> />
				</label> <input type='submit' value='Guess' />
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

						<form method='post'>
							<input type='submit' value='Play Again' />
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

			<form method='post'>
				<input type='submit' value='Play Again' />
			</form>
		
		<%
			}
		%>
		
		
		
		
	
</body>
</html>