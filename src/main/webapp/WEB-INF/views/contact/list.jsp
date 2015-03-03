<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Contact List</h1> <hr />

<c:if test="${!empty flashMessage}">
    <div class="alert alert-success">${flashMessage}</div>
</c:if>

<c:if test="${!empty flashError}">
    <div class="alert alert-danger">${flashError}</div>
</c:if>

<c:if test="${!empty contacts}">
    <table class="table table-responsive table-hover table-striped">
        <thead>
            <tr>
                <th>First Name</th>
                <th>Surname</th>
                <th>Details</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${contacts}" var="contact">
            <tr>
                <td>${contact.firstName}</td>
                <td>${contact.surname}</td>
                <td>
                    <spring:url value="/contact/details/${contact.id}" var="detailsUrl" htmlEscape="true" />
                    <a href="${detailsUrl}" class="btn btn-xs btn-default">
                        <i class="fa fa-folder"></i>
                    </a>
                </td>
                <td>
                    <spring:url value="/contact/edit/${contact.id}" var="editUrl" htmlEscape="true" />
                    <a href="${editUrl}" class="btn btn-xs btn-primary">
                        <i class="fa fa-edit"></i>
                    </a>
                </td>
                <td>
                    <spring:url value="/contact/delete/${contact.id}" var="deleteUrl" htmlEscape="true" />
                    <a href="${deleteUrl}" class="btn btn-xs btn-danger">
                        <i class="fa fa-trash"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if> 

<spring:url value="/contact/create" var="createUrl" htmlEscape="true" />
<a href="${createUrl}" class="btn btn-primary">
    <i class="fa fa-plus"></i> New Contact
</a> 