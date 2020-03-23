
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
    <center><h1>Welcome to IRCTC . E-Ticket Reservation System</h1><hr>
    <br>
    <form action="LogInServlet" method="post">
        UserName : <input type="text" name="userid" placeholder="Enter User Id" required><br><br>
        Password : <input type="password" name="password" placeholder="Enter Password"required ><br><br>
        <input type="submit" value="LogIn"><br><br>
        <span style="color : Red; font-weight : bold; " >
        <%
                    if(null!=request.getAttribute("errorMessage"))
                    {
                        out.println(request.getAttribute("errorMessage"));
                    }


        %>
        </span>
         <span style="color : Green; font-weight : bold; " >
            <%
               if(null!=request.getAttribute("successMessage"))
                                   {
                                      out.println(request.getAttribute("successMessage"));
                                   }
            %>
            </span>
        <h3>Quick links</h3>
        <a href="RegistrationPage.jsp">New User?Register</a><br><br>
        <a href="#">Contact Us</a><br><br>
        <a href="#">Admin LogIn</a>
    </form>

        </center>
    </body>
</html>
