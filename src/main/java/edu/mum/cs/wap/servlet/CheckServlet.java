package edu.mum.cs.wap.servlet;

import edu.mum.cs.wap.model.Quiz;
import edu.mum.cs.wap.model.QuizData;

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
            throws ServletException, IOException {
        QuizData quizData;
        HttpSession session = request.getSession();
        if (session.getAttribute("quizData") == null) {
            quizData = new QuizData();
            session.setAttribute("quizData", quizData);
        } else {
            String answer = request.getParameter("answer");
            quizData = (QuizData) session.getAttribute("quizData");
            quizData.check(answer);
            session.setAttribute("quizData", quizData);
        }


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String question = quizData.nextQuestion();
        out.write("<html>\n" +
                "<head>\n" +
                "    <title>Quiz</title>\n" +
                "</head>\n" +
                "<body>");
        out.write("  <h1>The Number Quiz</h1> <br />");
        out.write("<p>Your current score is " + quizData.getScore() + ".</p> <br />");
        if (question == null) {
            out.println("<p>You have completed the quiz, with a score " + quizData.getScore() + " out of " + 5 + "</p>");
            session.invalidate();
        } else {
            out.println("<form action=\"check\" method=\"post\">");
            out.println("<p> " + question+ "</p>");
            out.println(" <p>Your answer:</p> <input type=\"text\" name=\"answer\" >");
            out.println(" <br /> <br />");
            out.println(" <input type=\"submit\" value=\"Submit\">");
            out.println("</form>");
        }
        out.println("</body> </html>");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request,response);
    }
}
