<%-- 
    Document   : Report
    Created on : Dec 14, 2018, 3:40:38 AM
    Author     : EMDES
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="../container/header.jsp"/>
    </head>
    <body>
        <jsp:include page="../container/navbaremployee.jsp"/>
        <jsp:include page="../container/body1.jsp"/>
        <!-- Layer1 -->
        <div class="row">
            <div class="col-lg-12">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Title</h1>
                        <div class="panel panel-default">
                            <!-- /.panel-heading -->
                            <div class="card" style="width:70%;">
                                <img class="card-img-top" src="img_avatar1.png" alt="Card image" style="width:100%;margin-bottom:0">
                                <div class="card-body">
                                    <h4 class="card-title" style="margin-top:0">John Doe</h4>
                                    <p class="card-text">Some example text some example text. John Doe is an architect and engineer</p>
                                    <a href="javascript:void(0)" class="btn btn-primary">See Profile</a>
                                </div>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
            </div>
        </div>
        <!-- /.Layer 1 End-->
        <jsp:include page="../container/body2.jsp"/>
    </body>
</html>

