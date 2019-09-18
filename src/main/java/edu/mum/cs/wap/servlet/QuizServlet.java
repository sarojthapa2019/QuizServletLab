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

@WebServlet("/next")
public class QuizServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        String quiz = request.getParameter("quiz");
        String question = "3, 1, 4, 1, 5";
        HttpSession session =request.getSession();
        if(quiz == null){
            session.setAttribute("quiz", new Quiz());
            session.setAttribute("question", question);
        }

        request.getRequestDispatcher("check").forward(request, response);
    }
}
