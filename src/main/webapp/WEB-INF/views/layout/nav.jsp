<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <spring:url value="/" var="homeUrl" htmlEscape="true" />
            <a class="navbar-brand" href="${homeUrl}">Contact Manager</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active">
                    <a href="${homeUrl}">Home</a>
                </li>
                <li>
                    <spring:url value="/contact/create" var="createUrl" htmlEscape="true" />
                    <a href="${createUrl}">New</a>
                </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>