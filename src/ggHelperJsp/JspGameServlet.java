package ggHelperJsp;

import helperPack.PlayMusicHelper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JspGameServlet")
public class JspGameServlet  extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String remainingLife = request.getParameter("lives");
		String alreadyguessed[] = new String[10];
		
		int x;
		if(remainingLife == null) 
			{
			x=10;
			}
		else
		{
		x = Integer.parseInt(remainingLife);
		}
		x--;
		
		 request.setAttribute("lives", x);
		 request.getRequestDispatcher("GGGame.jsp").forward(request, response);
		
		
	}
}