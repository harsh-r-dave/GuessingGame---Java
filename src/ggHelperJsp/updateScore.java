package ggHelperJsp;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

@WebServlet("/servletUpdateScore")
public class updateScore extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName).newInstance();
			
			//Establishing the connection to the database
			String conURL="jdbc:mysql://192.168.43.48:3306/group4_project2";
			String user = "root";
			String password = "admin";
			Connection con = DriverManager.getConnection(conURL, user, password);
			
			System.out.println("Connected.......");
			HttpSession Sess = request.getSession();
			String username = (String) Sess.getAttribute("user");
			String score = (String) Sess.getAttribute("score");
			
			System.out.println(score);
			String queryStr =  "update user set score = ? where user_name= ?";
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(queryStr);
			ps.setString(2, username);
			ps.setInt(1, Integer.parseInt(score));
			int res=ps.executeUpdate();
			if (res == 1){
				HttpSession session = request.getSession();
				session.setAttribute("user",username);
				response.sendRedirect(request.getContextPath() + "/Home.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
