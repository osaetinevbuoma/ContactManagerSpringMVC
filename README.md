Contact Manager using Spring MVC
========================================

The Contact Manager sample app is a simple CRUD application to get a basic understanding of Spring MVC.
Features of the app include:
<ul>
    <li>Creating, editing and deleting contacts</li>
    <li>Creating their emails/phone numbers using javascript</li>
    <li>Uploading profile image (though this still has a lot that can be improved upon)</li>
</ul>

To-Do
-------------

Making the file upload more robust and efficient. Because of the unpredictability of deployment containers (some explode WAR
files and some don't), a better storage system on the server is necessary (except when using cloud storage and CDN). Absolutes
paths work but will have out how that affects the files from server type to another. Also look into proper ways of serving
the files to client browser because they won't be stored in the /webapp. <br /> <br />
Uploaded images cache on client browser and setting cache to 0 in mvc:resources  doesn't solve the problem. Contact images need to change as soon as a new one is uploaded.
