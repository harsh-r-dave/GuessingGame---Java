package ggHelperJsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/servletLogin")
public class servletLogin extends HttpServlet {

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
			
			String uname = request.getParameter("user_name");
			String psw = request.getParameter("t1");
	
			String queryStr =  "SELECT user_name from user WHERE user_name = ? and password = ?";
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(queryStr);
			ps.setString(1, uname);
			ps.setString(2, psw);
			ResultSet res=ps.executeQuery();
			String username = "";
			while(res.next())
			 {
			 username = res.getString("user_name");
			}
			if (username.equals(uname)){
				HttpSession session = request.getSession();
				session.setAttribute("user",uname);
				response.sendRedirect(request.getContextPath() + "/Home.jsp");
			}
			else{
				
				PrintWriter out = response.getWriter();
				out.print("Sorry UserName or Password Error!");  
		        RequestDispatcher rd=request.getRequestDispatcher("/Home.jsp");
		        rd.include(request, response);  
		        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
