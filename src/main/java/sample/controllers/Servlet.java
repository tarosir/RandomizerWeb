package sample.controllers;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RandomStudentVsStudentController randomStudentVsStudentController = new RandomStudentVsStudentController();
        Random random = new Random();
        String json = random.run();
        req.setAttribute("jsonData", json);

        forward("json-page.jsp", req, resp);


    }

    private void forward(String url, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher(url);
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }


}
