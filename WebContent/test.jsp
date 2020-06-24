<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%!
// サーブレットのinitメソッドに相当
public void jspInit() {
    try {
        // JDBCドライバをロー
        Class.forName("org.postgresql.Driver");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fruitテーブルの内容(JSP版)</title>
</head>

<body>
<%
        // データベースへのアクセス開始

        String url = "jdbc:postgresql://localhost:5432/kentechdb";
	   String id = "postgres";
	   String pass = "ahkw0618";


        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // データベースに接続するConnectionオブジェクトの取得
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kentechdb","postgres","ahkw0618");
            // データベース操作を行うためのStatementオブジェクトの取得
            stmt = con.createStatement();
            // SQL()を実行して、結果を得る
         // SQL()を実行して、結果を得る
            rs = stmt.executeQuery("select no, name, price from fruit");

            // 得られた結果をレコードごとに表示
            while (rs.next()) {
%>
                <tr>
                <%-- レコードのNOフィールドを表示 --%>
                <td><%= rs.getInt("no")%></td>
                <%-- レコードのNAMEフィールドを表示 --%>
                <td><%= rs.getString("name")%></td>
                <%-- レコードのPRICEフィールドを表示 --%>
                <td><%= rs.getInt("price")%></td>
                </tr>
<%
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // データベースとの接続をクローズ
            try { rs.close(); } catch (Exception e) {}
            try { stmt.close(); } catch (Exception e) {}
            try { con.close(); } catch (Exception e) {}
        }
%>

        </table>
</body>
</html>