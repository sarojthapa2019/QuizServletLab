package edu.mum.cs.wap.servlet;

import edu.mum.cs.wap.model.Quiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/check")
public class CheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        String answer = request.getParameter("answer");

        HttpSession s = request.getSession();
        Quiz q = (Quiz) s.getAttribute("quiz");
        String question = (String) s.getAttribute("question");
        q.setQuestion(question);
        q.setAnswer(answer);
        q.checkQuiz();
        s.setAttribute("quiz",q);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.write("<html>\n" +
                "<head>\n" +
                "    <title>Quiz</title>\n" +
                "</head>\n" +
                "<body>");
        out.write("  <h1>The Number Quiz</h1> <br />");
        out.write("<p>Your current score is " +q.getScore() + ".</p> <br />");
        out.println("<form action=\"check\" method=\"post\">");
        out.println("<p> " + q.getRandomQuestion() + "</p>");
        out.println(" <p>Your answer:</p> <input type=\"text\" name=\"answer\" >");
        out.println(" <br /> <br />");
        out.println(" <input type=\"submit\" value=\"Submit\">");
        out.println("</form>");
        out.println("</body> </html>");


    }
}
