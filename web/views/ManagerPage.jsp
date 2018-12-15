<%-- 
    Document   : ManagerPage
    Created on : Dec 13, 2018, 1:26:39 PM
    Author     : yudafatah
--%>

<%@page import="controllers.LeaveRequestController"%>
<%@page import="interfaces.LeaveRequestInterface"%>
<%@page import="connection.HibernateUtil"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="entities.LeaveRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <!-- Tell the browser to be responsive to screen width -->
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<!-- Bootstrap 3.3.7 -->
	<link rel="stylesheet" href="../asset/bootstrap/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <body>
        <% 
            String getDepartmetId = "", getDepartmentName = "", getManager = "", getLocation = "";
            if (session.getAttribute("LR") != null) {
                LeaveRequest lr = (LeaveRequest) session.getAttribute("LR");
//                getDepartmetId = dep.getDepartmentId().toString();
//                getDepartmentName = dep.getDepartmentName();
//                getManager = dep.getManagerId().getFirstName();
//                getLocation = dep.getLocationId().getCity();
                
            }
            String id = "";
            if(session.getAttribute("Id") != null){
                id = session.getAttribute("Id").toString();
            }
            SessionFactory factory = HibernateUtil.getSessionFactory();
            LeaveRequestInterface lri = new LeaveRequestController(factory);
        %>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel basic-default">
                        <div class="panel-heading">
                            <h3>Search</h3>
                        </div>
                        <div class="panel-body">
                            <form method="POST" action="../#">
                                <div class="form-group">
                                    <input type="text" class="form-control" name="search">
                                </div>
                                
                                <button clas type="submit" class="btn btn-info">Submit</button>
                                
                            </form>
                        </div>
                    </div>
                    <div class="panel basic-default">
                        <div class="panel-heading">
                            <h3>Table Leave Request</h3>
                        </div>
                        <div class="panel-body">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>No</th>
                                        <th>Employee Name</th>
                                        <th>Leave Request Type</th>
                                        <th>Request Date</th>
                                        <th>Start Date</th>
                                        <th>End Date</th>
                                        <th>Duration</th>
                                        <th>Note Request</th>
                                        <th>Image</th>
                                        <th width="200">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                    int no = 1;
                                    for (Object obj : lri.getDatasWaiting(new LeaveRequest(), id)) { 
                                        LeaveRequest lr = (LeaveRequest) obj;
                                    %>
                                        <tbody>
                                            <tr>
                                                <td><%= no %></td>
                                                <td><%= lr.getEmployeeId().getEmployeeName() %></td>
                                                <td><%= lr.getTypeLrId().getTypeName() %></td>
                                                <td><%= lr.getRequestDate()%></td>
                                                <td><%= lr.getStartDate() %></td>
                                                <td><%= lr.getEndDate() %></td>
                                                <td><%= lr.getLrDuration() %></td>
                                                <td><%= lr.getNoteRequest() %></td>
                                                <td><%= lr.getImage() %></td>
                                                <td>
                                                    <a href="../approve?id=<%= lr.getLrId()%>&empId=<%= id %>">
                                                        <input class="btn btn-warning btn-md" type="button" value="Update" />
                                                    </a>
                                                    <a href="../reject?id=<%= lr.getLrId() %>">
                                                        <input class="btn btn-info btn-md" type="button" value="Delete" />
                                                    </a>
                                                </td>
                                            </tr>
                                        </tbody>
                                    <%
                                    no++;
                                    }
                                    %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Bootstrap 3.3.7 -->
	<script src="../asset/bootstrap/js/bootstrap.min.js"></script>
    </body>
    </body>
</html>
