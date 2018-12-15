<%-- 
    Document   : StaffPage
    Created on : Dec 13, 2018, 1:26:31 PM
    Author     : yudafatah
--%>

<%@page import="entities.LeaveRequestType"%>
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
                            <h3>Form Leave Request</h3>
                        </div>
                        <div class="panel-body">
                            <form method="POST" action="../adRegion">
                                <div class="form-group">
                                    <label>Type Leave Request</label>
                                    <select class="form-control" name="typeLr">
                                        <%
                                        for (Object obj : lri.getAllDatasOrderById(new LeaveRequestType())) {
                                            LeaveRequestType lrt = (LeaveRequestType) obj;
                                            %>
                                            <option value="<%= lrt.getTypeLrId()%>"><%= lrt.getTypeName()%></option>    
                                            <%
                                        }    
                                        %>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Start Date</label>
                                    <input type="Date" class="form-control" name="startDate" value="<%= getDepartmentName %>">
                                </div>
                                <div class="form-group">
                                    <label>End Date</label>
                                    <input type="Date" class="form-control" name="endDate">
                                </div>
                                <div class="form-group">
                                    <label for="notereq">Note</label>
                                    <textarea class="form-control" rows="5" id="notereq"></textarea>
                                </div>
                                <div>
                                    <label for="upload">Upload Proof of Agreement Image</label>
                                    <input type = "file" name = "file" size = "50" />
                                </div>
                                <button clas type="submit" class="btn btn-info">Submit</button>
                                <% session.removeAttribute("department"); %>
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
                                        <th>Leave Request Type</th>
                                        <th>Request Date</th>
                                        <th>Start Date</th>
                                        <th>End Date</th>
                                        <th>Duration</th>
                                        <th>Note Request</th>
                                        <th>Note Rejected</th>
                                        <th>Request Status</th>
                                        <th>Image</th>
                                        <th width="200">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                    int no = 1;
                                    for (Object obj : lri.getAlls(new LeaveRequest(), "", id)) { 
                                        LeaveRequest lr = (LeaveRequest) obj;
                                    %>
                                        <tbody>
                                            <tr>
                                                <td><%= no %></td>
                                                <td><%= lr.getTypeLrId().getTypeName() %></td>
                                                <td><%= lr.getRequestDate()%></td>
                                                <td><%= lr.getStartDate() %></td>
                                                <td><%= lr.getEndDate() %></td>
                                                <td><%= lr.getLrDuration() %></td>
                                                <td><%= lr.getNoteRequest() %></td>
                                                <td><%= lr.getNoteReject() %></td>
                                                <td><%= lr.getRequestStatus() %></td>
                                                <td><%= lr.getImage() %></td>
                                                <td>
                                                    <a href="../update?param=cancel">
                                                        <input class="btn btn-warning btn-md" type="button" value="Cancel" />
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
</html>
