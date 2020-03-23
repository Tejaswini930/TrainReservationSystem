
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>JSP Page</title>
    </head>
    <body>


    <center><h1>Welcome to IRCTC . E-Ticket Reservation System</h1><hr>
    <br>
    <form action="RegistrationServlet" method="put">

<table>

      <tr><td>Name </td> <td> : <input type="text" name="name" placeholder="Enter FullName" required></td> </tr>
       <tr><td> Gender</td><td>: <input type="radio" name="gender" value="Male" required>Male <input type="radio" name="gender" value="Female" required>Female</td></tr>        <tr><td>  SetPassword   </td><td> : <input type="password" name="password" placeholder="Enter Password" required ></td></tr>
       <tr><td>Age</td><td> :<input type="number" name="age" required></td></tr>
       <%=session.getAttribute("user");%>
  </table>
  <br><br>
        <input type="submit" value="Register"><br><br>

    </form>

        </center>
    </body>
</html>
