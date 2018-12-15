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
                        <h1 class="page-header">Request List</h1>
                        <div class="panel panel-body">
                            <button class="btn btn-success col-xs-12 col-lg-2" data-toggle="modal" data-target="#myModal">
                                <span class="fa fa-plus"></span> Create Leave Request
                            </button>
                        </div>
                        <div class="panel panel-default">
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>No.</th>
                                            <th>Title</th>
                                            <th>Category</th>
                                            <th>StartDate</th>
                                            <th>EndDate</th>
                                            <th>Days Off</th>
                                            <th>Statuse</th>
                                            <th>Note</th>
                                            <th>Image</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr class="odd gradeX">
                                            <td> </td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win yuku3+</td>
                                            <td>Win yuk31+</td>
                                            <td>Win gtftrlk+</td>
                                            <td>Win yukyu94+</td>
                                            <td>Win 9hyhyt+</td>
                                            <td>Win yukyu94+</td>
                                            <td>Win 9hyhyt+</td>
                                            <td><a class="btn btn-warning" data-toggle="modal" data-target="#myModalDetail">
                                                    <span class="fa fa-edit"> </span> Detail</a>
                                                <a class="btn btn-danger" data-toggle="modal" data-target="#myModalCancle">
                                                    <span class="fa fa-trash"></span></a></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>       
            </div>
        </div>

        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">Create Leave Request</h4>
                    </div>
                    <div class="modal-body">
                        <div class="box box-primary">
                            <form role="form">
                                <div class="box-body">
                                    <div class="form-group">
                                        <label for="Title">Title</label>
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-info"></i>
                                            </div>
                                            <input type="text" class="form-control" placeholder="Title">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="stardate">Start Date</label>
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-calendar"></i>
                                            </div>
                                            <input type="text" class="form-control pull-right" id="startdate">
                                        </div>                                    
                                    </div>
                                    <div class="form-group">
                                        <label for="enddate">End Date</label>
                                        <div class="input-group date">
                                            <div class="input-group-addon">
                                                <i class="fa fa-calendar"></i>
                                            </div>
                                            <input type="text" class="form-control pull-right" id="enddate">
                                        </div> 
                                    </div>
                                    <div class="form-group">
                                        <label for="Note">Note</label>
                                        <div class="input-group date">
                                            <div class="input-group-addon">
                                                <i class="fa fa-envelope"></i>
                                            </div>
                                            <textarea class="form-control" id="note" rows="3" placeholder="Note ..."></textarea>
                                        </div> 
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputFile">Letter Scan</label>
                                        <input type="file" id="exampleInputFile">
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-success">Submit</button>
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Cancle</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="myModalDetail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel"><b>Detail Leave Request</b></h4>
                    </div>
                    <div class="modal-body">
                        <p> DETAIL </p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="myModalCancle" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel"> Cancle Request
                        </h4>
                    </div>
                    <div class="modal-body">
                        <b> Are You Sure? 
                            <br> Wan To Cancle This Request</b>                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Sure</button>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="../container/body2.jsp"/>
    </body>
</html>

