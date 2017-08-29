package ggHelperJsp;

import helperPack.PlayMusicHelper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JspHelperServlet")
public class JspHelperServlet  extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		if(request.getParameter("play_music") != null) {
			String file_path = request.getParameter("file_path");
			ggHelperJsp.GGHelper.playMusic(file_path);
		}
		else if(request.getParameter("stop_music") != null) {
			ggHelperJsp.GGHelper.stopMusic();
		}
		else if (request.getParameter("check") != null) {
			
		}
	}
}