package ggHelperJsp;

import helperPack.PlayMusicHelper;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ImageCapture")
public class GGImageCapture extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String imagesize = request.getParameter("imagesize");
		File fi;
		if(imagesize==null || Integer.parseInt(imagesize)>11)
		{
		fi = new File("C:/Users/shivam/workspace/Group4_Proj2/WebContent/1.jpg");
		}
		else
		{
		fi = new File("C:/Users/shivam/workspace/Group4_Proj2/WebContent/"+imagesize+".jpg");
		}
		byte[] imageBytes = Files.readAllBytes(fi.toPath());
		response.setContentType("image/jpeg");
		
		response.setContentLength(imageBytes.length);
		response.getOutputStream().write(imageBytes);
	}
}