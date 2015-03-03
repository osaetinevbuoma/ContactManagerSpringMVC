$(document).ready(function () {

    /**
     * Create emails for contact* 
     */
    $("#emailForm").submit(function (e) {
        e.preventDefault();
        
        $("#email").attr({disabled: "disabled"});
        $("#emailForm button").attr({disabled: "disabled"});
        
        $.post("/contact/"+$("#contactId").val()+"/email/save", {email: $("#email").val()}, function (response) {
            if (response) {
                $("#email").attr({disabled: false});
                $("#emailForm button").attr({disabled: false});
                
                if (response.status == 200) {
                    var email = "" +
                        "<div class='emails' id='email"+response.id+"'>" +
                        "   " + response.email + " " +
                        "   &nbsp;" +
                        "   <span>" +
                        "       <a href='#' id='"+response.id+"' class='btn btn-danger btn-xs'>" +
                        "           <i class='fa fa-minus'></i>" +
                        "       </a>" +
                        "   </span>" +
                        "</div>";
                    
                    $("#appendEmails").append(email);
                    $("#email").val("");
                }
            }
        });
    });

    /**
     * Delete contact email
     */
    $(".emails a").click(function (e) {
        e.preventDefault();
        
        var id = $(this).attr("id");
        var url = "/contact/"+$("#contactId").val()+"/email/delete/"+id;

        $.get(url, function (response) {
            if (response.status == 200) {
                $("#email"+id+"").hide();                
            }
        });
    });

    /**
     * Create phone numbers for contact*
     */
    $("#phoneForm").submit(function (e) {
        e.preventDefault();

        $("#phone").attr({disabled: "disabled"});
        $("#phoneForm button").attr({disabled: "disabled"});

        $.post("/contact/"+$("#contactId").val()+"/phone/save", {phone: $("#phone").val()}, function (response) {
            if (response) {
                $("#phone").attr({disabled: false});
                $("#phoneForm button").attr({disabled: false});

                if (response.status == 200) {
                    var phone = "" +
                        "<div class='phones' id='phone"+response.id+"'>" +
                        "   " + response.phone + " " +
                        "   &nbsp;" +
                        "   <span>" +
                        "       <a href='#' id='"+response.id+"' class='btn btn-danger btn-xs'>" +
                        "           <i class='fa fa-minus'></i>" +
                        "       </a>" +
                        "   </span>" +
                        "</div>";

                    $("#appendPhones").append(phone);
                    $("#phone").val("");
                }
            }
        });
    });

    /**
     * Delete contact phone
     */
    $(".phones a").click(function (e) {
        e.preventDefault();

        var id = $(this).attr("id");
        var url = "/contact/"+$("#contactId").val()+"/phone/delete/"+id;

        $.get(url, function (response) {
            if (response.status == 200) {
                $("#phone"+id+"").hide();
            }
        });
    });
    
});