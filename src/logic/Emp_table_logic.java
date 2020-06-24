/*    */ package logic;
/*    */
/*    */ import beans.Userdata;
/*    */ import dao.Dao;


/*    */ public class Emp_table_logic {
/*    */    public Userdata login(int emp_no) {
/* 11 */       Dao dao = new Dao();
/* 12 */       Userdata data = dao.select_emp(emp_no);
/* 13 */       return data;
/*    */    }
/*    */ }
