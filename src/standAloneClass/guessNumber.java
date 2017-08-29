package standAloneClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/guessNumber")
public class guessNumber extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        PrintWriter out = response.getWriter();
        int num = Integer.parseInt(request.getParameter("number"));
        int randNumber = Integer.parseInt(session.getAttribute("randNum").toString());

        out.println("<html>" +
                "<head>" +
                "<title>Guess Number Game</title>" +
                "</head>" +
                "<body>");
        if(num == randNumber){
            out.println("Congratulation you won");
            out.println("<br><a href='http://localhost:8081/Group4_Proj2/guessNumber'>Try Again</a>");
        }else if(num > randNumber){
            out.println("Number is too high. Try Again!");
            out.println("<br><a href='http://localhost:8081/Group4_Proj2/guessNumber'>Try Again</a>");
        }else{
            out.println("Number is too low. Try Again!");
            out.println("<br><a href='http://localhost:8081/Group4_Proj2/guessNumber'>Try Again</a>");
        }
        out.println("</body></html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random rand = new Random();
        int x = rand.nextInt(10);

        HttpSession session = request.getSession(true);
        session.setAttribute("randNum", x);

        PrintWriter out = response.getWriter();
        
      /*  out.println("<html>" +
                "<head>" +
                    "<title>Guess Number Game</title>" +
                "</head>" +
                "<body>" +
                    "Enter the number between 1 and 10"+
                    "<form method=POST action=\"http://localhost:8081/Group4_Proj2/guessNumber\">" +
                        "<input type=number name=number />" +
                        "<input type=SUBMIT value=Enter />" +
                    "</form>"+
                "</body></html>");
                */
        System.out.println(x);
        request.getRequestDispatcher("guessguess.jsp").forward(request, response);
    }
}