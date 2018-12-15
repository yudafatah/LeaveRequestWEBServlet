<%-- 
    Document   : nav1
    Created on : Dec 13, 2018, 9:20:14 AM
    Author     : EMDES
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="wrapper">
    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><b>LEAVE</b> REQUEST</a>
        </div>
        <ul class="nav navbar-top-links navbar-right">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-messages">
                    <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                    </li>
                    <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="login.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                    </li>
                </ul>
            </li>
        </ul>

        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li>
                        <a href="index.jsp"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-star fa-fw"></i> Your Leave Request<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="request.jsp">Leave Request</a>
                            </li>
                            <li>
                                <a href="report.jsp">History Request</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="report.jsp"><i class="fa fa-files-o fa-fw"></i> Report</a>
                    </li>
                    <li>
                        <br>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-user fa-fw"></i> Account<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="Profile.jsp">Profile</a>
                            </li>
                            <li>
                                <a href="#">Log Out</a>
                            </li>
                        </ul>
                    </li>
                    <li class="sidebar-search">
                        <div class="input-group custom-search-form">
                            <input type="text" class="form-control" placeholder="Employee Name" readonly="true">
                            <span class="input-group-btn">      
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-star"></i>
                                </button>
                            </span>
                        </div><br>
                        <div class="input-group custom-search-form">
                            <input type="text" class="form-control" placeholder="Manager Name" readonly="true">
                            <span class="input-group-btn">      
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-user"></i>
                                </button>
                            </span>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
