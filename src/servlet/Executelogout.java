/*    */ package servlet;
/*    */ import java.io.IOException;

/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.annotation.WebServlet;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;

/*    */
/*    */ import beans.Userdata;

/*    */
/*    */ @WebServlet({"/Executelogout"})
/*    */ public class Executelogout extends HttpServlet {
/*    */    private static final long serialVersionUID = 1L;
/*    */
/*    */    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 34 */       HttpSession session = request.getSession();
/* 35 */       Userdata session_data = (Userdata)session.getAttribute("LOGIN_INFO");
/* 36 */       if (session_data != null) {
/* 38 */          session.invalidate();
/* 39 */          response.sendRedirect("Login");
/*    */       } else {
/* 41 */          response.sendRedirect("Login");
/*    */       }
/* 43 */    }
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 50 */       this.doGet(request, response);
/* 51 */    }
/*    */ }
