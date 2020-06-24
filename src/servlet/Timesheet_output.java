/*    */ package servlet;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;

/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletContext;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.annotation.WebServlet;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;

/*    */
/*    */ import beans.Timesheet;
/*    */ import beans.Userdata;
/*    */ import logic.Timesheet_logic;
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ @WebServlet({"/timesheet_output"})
/*    */ public class Timesheet_output extends HttpServlet {
/*    */    private static final long serialVersionUID = 1L;
/*    */
/*    */    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 34 */       this.doPost(request, response);
/* 35 */    }
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 43 */       HttpSession session = request.getSession();
/* 44 */       Userdata session_data = (Userdata)session.getAttribute("LOGIN_INFO");
/*    */       new Userdata();
/*    */       new ArrayList();
/* 47 */       Timesheet_logic logic = new Timesheet_logic();
/* 48 */       if (session_data != null) {
/*    */
/* 50 */          ArrayList<Timesheet> timesheets = logic.table(session_data.getEmp_no());
/* 51 */          if (timesheets != null) {
					//response.sendRedirect("Complete");
					request.setAttribute("timesheets", timesheets);
/* 53 */             ServletContext context = this.getServletContext();
/* 54 */             RequestDispatcher dispatch = context.getRequestDispatcher("/table.jsp");
/* 55 */             dispatch.forward(request, response);
/*    */
/*    */
/*    */          }
/*    */       } else {
/* 60 */          response.sendRedirect("Login");
/*    */
/*    */
/*    */
/*    */       }
/*    */
/* 66 */    }
/*    */ }

/*
	DECOMPILATION REPORT

	Decompiled from: C:\Users\_remiya_\Desktop\pleiades\workspace\kentech\WEB-INF\classes\servlet\Timesheet_output.class
	Total time: 13 ms

	Decompiled with FernFlower.
*/