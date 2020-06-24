 package servlet;
 import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Timesheet;
import beans.Userdata;
import logic.Timesheet_logic;

 @WebServlet({"/timesheet_output"})
 public class Timesheet_output extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request, response);
    }






    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession();
       Userdata session_data = (Userdata)session.getAttribute("LOGIN_INFO");
       new Userdata();
       new ArrayList();
       Timesheet_logic logic = new Timesheet_logic();
       if (session_data != null) {
         ArrayList<Timesheet> timesheets = logic.table(session_data.getEmp_no());
         if (timesheets != null) {
        	 //response.sendRedirect("Complete");
        	 request.setAttribute("timesheets", timesheets);
        	 ServletContext context = this.getServletContext();
             RequestDispatcher dispatch = context.getRequestDispatcher("/table.jsp");
             dispatch.forward(request, response);
          }
       } else {
          response.sendRedirect("Login");
       }
    }
 }
