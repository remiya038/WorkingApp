/*    */ package beans;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class Userdata implements Serializable {
/*    */    private int emp_no;
/*    */    private String pass;
/*    */    private String name;
/*    */ 
/*    */    public int getEmp_no() {
/* 11 */       return this.emp_no;
/*    */    }
/*    */    public void setEmp_no(int emp_no) {
/* 14 */       this.emp_no = emp_no;
/* 15 */    }
/*    */    public String getPass() {
/* 17 */       return this.pass;
/*    */    }
/*    */    public void setPass(String pass) {
/* 20 */       this.pass = pass;
/* 21 */    }
/*    */    public String getName() {
/* 23 */       return this.name;
/*    */    }
/*    */    public void setName(String name) {
/* 26 */       this.name = name;
/* 27 */    }
/*    */ }
