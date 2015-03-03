<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="">

    <title>Spring MVC Contact Manager</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/stylesheets/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/stylesheets/bootstrap-theme.min.css" rel="stylesheet">
    <link href="/resources/stylesheets/font-awesome.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/resources/stylesheets/stylesheet.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <tiles:insertAttribute name="nav" />
    
    <div class="container">
        <div class="row">
            <div class="col-lg-10 col-lg-offset-1">
                <tiles:insertAttribute name="body" />
                <tiles:insertAttribute name="footer" />
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/resources/javascripts/jquery-1.11.2.min.js"></script>
    <script src="/resources/javascripts/bootstrap.min.js"></script>
    <script src="/resources/javascripts/javascript.js"></script>
</body>
</html>
