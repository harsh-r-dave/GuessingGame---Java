package ggHelperJsp;

import helperPack.PlayMusicHelper;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MusicServlet")
public class MusicPlayer extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletOutputStream stream = null;
	      BufferedInputStream buf = null;
	      try{
	     
	      stream = response.getOutputStream();
	      File mp3 = new File("D:/music.mp3");
	     
	      response.setContentType("audio/mpeg");
	      
	      response.addHeader("Content-Disposition","attachment; filename=" );

	      response.setContentLength( (int) mp3.length() );
	      
	      FileInputStream input = new FileInputStream(mp3);
	      buf = new BufferedInputStream(input);
	      int readBytes = 0;

	      while((readBytes = buf.read()) != -1)
	         stream.write(readBytes);

	     } catch (IOException ioe){
	     
	        throw new ServletException(ioe.getMessage());
	         
	     } finally {
	     if(stream != null)
	         stream.close();
	      if(buf != null)
	          buf.close();
	          }
		
	}
}