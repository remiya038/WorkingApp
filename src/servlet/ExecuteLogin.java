package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Userdata;
import logic.Emp_table_logic;

@WebServlet({"/ExecuteLogin"})
public class ExecuteLogin extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.sendRedirect("Login");
    }







   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession();

       Userdata session_data = (Userdata)session.getAttribute("LOGIN_INFO");
      new Userdata();
       if (session_data != null) {

          response.sendRedirect("Home");
      }
       Emp_table_logic login = new Emp_table_logic();
       String emp_str = request.getParameter("emp_no");
       String pass = request.getParameter("pass");
       String coment = null;

       if (this.checkEmpStr(emp_str) == 0) {
          int emp_no = Integer.parseInt(request.getParameter("emp_no"));
          Userdata data = login.login(emp_no);
          if (data != null) {
             if (pass.equals(data.getPass())) {
                session.setAttribute("LOGIN_INFO", data);
                response.sendRedirect("Home");
            } else {
                coment = "パスが違います";
                session.setAttribute("coment", coment);
                response.sendRedirect("Login");
            }
         } else {
             coment = "社員番号が見つかりません";
             session.setAttribute("coment", coment);
             response.sendRedirect("Login");
         }
      } else {
          if (this.checkEmpStr(emp_str) == 1) {
             coment = "社員番号が数値ではありません";
             session.setAttribute("coment", coment);
             response.sendRedirect("Login");
         }
          if (this.checkEmpStr(emp_str) == 2) {
            coment = "入力がありません";
             session.setAttribute("coment", coment);
             response.sendRedirect("Login");
         }
      }

    }



   private int checkEmpStr(String emp_str) {
      byte n;
       if (!this.checkNull(emp_str)) {
          if (!this.checkNumber(emp_str)) {
             n = 0;
         } else {
             n = 1;
         }
      } else {
          n = 2;
      }
       return n;
   }


   private boolean checkNull(String emp_str) {
       return emp_str.isEmpty();
   }


   private boolean checkNumber(String emp_str) {
      try {
          Integer.parseInt(emp_str);
          return false;
       } catch (NumberFormatException var3) {
          return true;
      }
   }
}
