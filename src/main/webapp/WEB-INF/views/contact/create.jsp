<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Create Contact</h1> <hr />

<div class="row">
    <div class="col-lg-6">
        
        <c:if test="${!empty flashMessage}">
            <div class="alert alert-success">${flashMessage}</div>
        </c:if>
        
        <form:form method="post" action="/contact/save" modelAttribute="contact">
            <form:errors path="*" cssClass="text-danger" />
            
            <div class="form-group">
                <form:label path="firstName" cssClass="control-label">First Name</form:label>
                <form:input path="firstName" cssClass="form-control" placeholder="Given Name" required="required" autofocus="autofocus" />
            </div>
            <div class="form-group">
                <form:label path="surname" cssClass="control-label">Surname</form:label>
                <form:input path="surname" cssClass="form-control" placeholder="Family Name" required="required" />
            </div>
            <div class="form-group">
                <form:label path="description" cssClass="control-label">Description</form:label>
                <form:textarea path="description" cssClass="form-control" placeholder="Brief description of contact" required="required" />
            </div>
            <button type="submit" class="btn btn-primary">
                <i class="fa fa-plus"></i> Save Contact
            </button>
            &nbsp;
            <a href="/" class="btn btn-default">
                <i class="fa fa-list"></i> Contact List
            </a>
        </form:form>
    </div>
</div>