
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>JSP Page</title>
    </head>
    <body>


    <center><h1>Welcome to IRCTC . E-Ticket Reservation System</h1><hr>
    <br>
    <form action="RegistrationServlet" method="post">

<table>

      <tr><td>FullName </td> <td> : <input type="text" name="name" placeholder="Enter FullName" required></td> </tr>
      <tr><td>Email Id    </td><td> : <input type="email" name="email" placeholder="ex:abc@gmail.com" required></td></tr>
      <tr><td>  ContactNo  </td><td>: <input type="tel" name="phone" placeholder="Phone number" required></td></tr>
      <tr><td> Gender</td><td> <input type="radio" name="gender" value="Male" required>Male <input type="radio" name="gender" value="Female" required>Female</td></tr>
        <tr><td>  UserName    </td><td>: <input type="text" name="userid" placeholder="Enter User Id" required></td></tr>
        <tr><td>  SetPassword   </td><td> : <input type="password" name="password" placeholder="Enter Password" required ></td></tr>
         <tr><td> Re-enter Password</td><td> :  <input type="password" name="re-password" placeholder="Re-Enter password" required></td></tr>
		 <tr><td>Select Question</td><td> : <select name="security_question">
		             <option>What is your first School?</option>
					 <option>What is your first pet name?</option>
					 <option>Who is your favourite School teacher?</option>
		 </select></td></tr>
		 <tr><td>Enter Answer</td><td> : <input type="text" name="security_answer" placeholder="Type Your Answer" required></td></tr>


  </table>
  <br><br>
        <input type="submit" value="Register"><br><br>

    </form>

         <span style="color : Red; font-weight : bold; " >
            <%
                        if(null!=request.getAttribute("errorMessage"))
                        {
                            out.println(request.getAttribute("errorMessage"));
                        }


            %>
        </center>
    </body>
</html>
