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

@WebServlet("/servletRegistration")
public class servletRegister extends HttpServlet {

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
			
			String username = request.getParameter("uname");
			String psw = request.getParameter("psw");
	
			String queryStr =  "INSERT INTO user (user_name, password,score) VALUES(?,?,0)";
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(queryStr);
			ps.setString(1, username);
			ps.setString(2, psw);
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
