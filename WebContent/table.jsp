<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import = "beans.Timesheet,java.util.ArrayList,logic.Convert"%>
<%
ArrayList<Timesheet> timesheets = (ArrayList<Timesheet>) request.getAttribute("timesheets");
%>
<%Convert convert = new Convert(); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link  href="css/stylesheet.css" rel="stylesheet">
    <!-- BootstrapのCSS読み込み -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery読み込み -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- BootstrapのJS読み込み -->
    <script src="js/bootstrap.min.js"></script>
	<style>

    </style>
 <title>実行完了</title>
</head>
<body>
<div class="container mr-sm-0 ml-sm-0 mr-md-5 ml-md-5 ">
<table border="1" bordercolor="#333333">
<tr>
	<th>日付</th>
	<th>出勤時間</th>
	<th>退勤時間</th>
</tr>

<%
for(Timesheet timesheet:timesheets){
%>
<tr>
	<td>
	<%String dateStr = convert.dateStr(timesheet.getPunchin()); %>
	<%= dateStr %>
	</td>

	<td>
	<%String intime = convert.timeStr(timesheet.getPunchin()); %>
	<%= intime %>
	</td>

	<td>
	<%try{ %>
	<%String outtime = convert.timeStr(timesheet.getPunchout()); %>
	<%= outtime %>
	<%}catch(Exception e){ %>
	 処理中
	<%} %>
	</td>

</tr>
<%} %>

</table>
</div>
</body>
</html>