<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Details</h1> <hr>

<div class="row">
    <div class="col-lg-6">
        <div class="row">
            <div class="col-lg-12">
                <c:if test="${!empty flashError}">
                    <div class="alert alert-danger">${flashError}</div>
                </c:if>
                
                <div class="image">
                    <spring:url value="${contact.image}" var="imageUrl" htmlEscape="true" />
                    <img src="${imageUrl}" class="img-responsive img-thumbnail">
                    <br />
                </div>
                <form method="post" action="/contact/uploadImage/${contact.id}" enctype="multipart/form-data">
                    <div class="form-group">
                        <input type="file" name="image">
                    </div>
                    <button type="submit" value="Upload" class="btn btn-primary btn-sm">
                        <i class="fa fa-upload"></i> Upload
                    </button>
                </form>
            </div>
            
            <div class="col-lg-12">
                <br />
                <p>
                    <strong>Full Name</strong> <br/>
                    <div>${contact.firstName} ${contact.surname}</div>
                </p>
                <p>
                    <strong>Description</strong>
                    <div>${contact.description}</div>
                </p>
            </div>
        </div>
    </div>
    <div class="col-lg-6">
        <div class="row">
            <div class="col-lg-12">
                <h3>Email Addresses</h3> <hr />
                <c:if test="${!empty contact.emails}">
                    <c:forEach items="${contact.emails}" var="email">
                        <div class="emails" id="email${email.id}">
                            ${email.email}
                            &nbsp;
                            <span>
                                <a href="#" id="${email.id}" class="btn btn-danger btn-xs">
                                    <i class="fa fa-minus"></i>
                                </a>
                            </span>
                        </div>
                    </c:forEach>
                </c:if>
                <div id="appendEmails"></div>
                <form id="emailForm">
                    <input type="hidden" id="contactId" value="${contact.id}">
                    <input type="email" id="email" size="40" placeholder="Add Email Address" required="required">
                    &nbsp;
                    <button type="submit" class="btn btn-primary btn-sm">
                        <i class="fa fa-plus"></i>
                    </button>
                </form>
            </div>
            
            <div class="col-lg-12">
                <h3>Phone Numbers</h3> <hr />
                <c:if test="${!empty contact.phones}">
                    <c:forEach items="${contact.phones}" var="phone">
                        <div class="phones" id="phone${phone.id}">
                                ${phone.phone}
                            &nbsp;
                            <span>
                                <a href="#" id="${phone.id}" class="btn btn-danger btn-xs">
                                    <i class="fa fa-minus"></i>
                                </a>
                            </span>
                        </div>
                    </c:forEach>
                </c:if>
                <div id="appendPhones"></div>
                <form id="phoneForm">
                    <input type="text" id="phone" size="40" placeholder="Add Phone Number" required="required">
                    &nbsp;
                    <button type="submit" class="btn btn-primary btn-sm">
                        <i class="fa fa-plus"></i>
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>