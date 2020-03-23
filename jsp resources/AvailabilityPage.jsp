<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.*"%>
<%@page import="com.train.handlers.TrainAvailabilityHandler"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
	<head>
	<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
  border-right:1px solid #bbb;
}

li:last-child {
  border-right: none;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
  /*color : black;*/
}

.active {
  background-color: #4CAF50;
  cursor: default;
}

</style>

  <link href='https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/ui-lightness/jquery-ui.css' rel='stylesheet'>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" ></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" ></script>
  <script>
  (function( $ ) {
    $.widget( "custom.combobox", {
      _create: function() {
        this.wrapper = $( "<span>" )
          .addClass( "custom-combobox" )
          .insertAfter( this.element );

        this.element.hide();
        this._createAutocomplete();
        this._createShowAllButton();
      },

      _createAutocomplete: function() {
        var selected = this.element.children( ":selected" ),
          value = selected.val() ? selected.text() : "";

        this.input = $( "<input>" )
          .appendTo( this.wrapper )
          .val( value )
          .attr( "title", "" )
          .addClass( "custom-combobox-input ui-widget ui-widget-content ui-state-default ui-corner-left" )
          .autocomplete({
            delay: 0,
            minLength: 0,
            source: $.proxy( this, "_source" )
          })
          .tooltip({
            tooltipClass: "ui-state-highlight"
          });

        this._on( this.input, {
          autocompleteselect: function( event, ui ) {
            ui.item.option.selected = true;
            this._trigger( "select", event, {
              item: ui.item.option
            });
          },

          autocompletechange: "_removeIfInvalid"
        });
      },

      _createShowAllButton: function() {
        var input = this.input,
          wasOpen = false;

        $( "<a>" )
          .attr( "tabIndex", -1 )
          .attr( "title", "Show All Items" )
          .tooltip()
          .appendTo( this.wrapper )
          .button({
            icons: {
              primary: "ui-icon-triangle-1-s"
            },
            text: false
          })
          .removeClass( "ui-corner-all" )
          .addClass( "custom-combobox-toggle ui-corner-right" )
          .mousedown(function() {
            wasOpen = input.autocomplete( "widget" ).is( ":visible" );
          })
          .click(function() {
            input.focus();

            // Close if already visible
            if ( wasOpen ) {
              return;
            }

            // Pass empty string as value to search for, displaying all results
            input.autocomplete( "search", "" );
          });
      },

      _source: function( request, response ) {
        var matcher = new RegExp( $.ui.autocomplete.escapeRegex(request.term), "i" );
        response( this.element.children( "option" ).map(function() {
          var text = $( this ).text();
          if ( this.value && ( !request.term || matcher.test(text) ) )
            return {
              label: text,
              value: text,
              option: this
            };
        }) );
      },

      _removeIfInvalid: function( event, ui ) {

        // Selected an item, nothing to do
        if ( ui.item ) {
          return;
        }

        // Search for a match (case-insensitive)
        var value = this.input.val(),
          valueLowerCase = value.toLowerCase(),
          valid = false;
        this.element.children( "option" ).each(function() {
          if ( $( this ).text().toLowerCase() === valueLowerCase ) {
            this.selected = valid = true;
            return false;
          }
        });

        // Found a match, nothing to do
        if ( valid ) {
          return;
        }

        // Remove invalid value
        this.input
          .val( "" )
          .attr( "title", value + " didn't match any item" )
          .tooltip( "open" );
        this.element.val( "" );
        this._delay(function() {
          this.input.tooltip( "close" ).attr( "title", "" );
        }, 2500 );
        this.input.autocomplete( "instance" ).term = "";
      },

      _destroy: function() {
        this.wrapper.remove();
        this.element.show();
      }
    });
  })( jQuery );

  $(function() {
    $( "#combobox" ).combobox();
    $( "#toggle" ).click(function() {
      $( "#combobox" ).toggle();
    });
  });
   $(function() {
      $( "#combobox1" ).combobox();
      $( "#toggle" ).click(function() {
        $( "#combobox1" ).toggle();
      });
    });
     function bookTicket(tr_no, src, destin){

     alert(tr_no, src, destin);

     }

  </script>
    </head>



    <body>

    <center><h1>Welcome to IRCTC . E-Ticket Reservation System</h1><hr>
        <br>
        <ul>
      <li><a class="active">Check Availability </a></li>
      <li> <a href="BookingPage.jsp">Book Tickets</a></li>
      <li><a href="my_ticket_history.html">My Ticket History</a></li>
      <li><a  href="upcoming_journey.html">Upcoming Journey</a></li>
      <li><a  href="upcoming_journey.html">Modify Bookings</a></li>
      <li style="float:right"><a href="LogInPage.jsp">LogOut</a></li>
    </ul>
    <br><br><br><br>


     <%!

      TrainAvailabilityHandler trainAvailabilityHandler = new TrainAvailabilityHandler();
      List sources = trainAvailabilityHandler.getAllSource();
      List destinations = trainAvailabilityHandler.getAllDestination();


      %>


      <form method="get" action="Available">
      <table cellpadding="15">
        <tr>
          <th colspan="2">
            <b>IRCTC</b>
          </th>
        </tr>
        <tr>
          <th>
            Source
          </th>
          <td>
                <select id="combobox" name="source" required>
                    <option value="">Select Station</option>
                    <% for(int i=0;i<sources.size();i++)
                    { %>
                    <option value="<%=sources.get(i)%>"><%=sources.get(i)%></option>
                    <% } %>
                </select>
          </td>
             </tr>
        <tr>
          <th>
            Destination
          </th>
          <td>
                        <select id="combobox1" name="destination" required>
                            <option value="">Select Station</option>
                            <% for(int i=0;i<destinations.size();i++)
                            { %>
                            <option value="<%=destinations.get(i)%>"><%=destinations.get(i)%></option>
                            <% } %>
                        </select>
          </td>
        </tr>

        <tr>
          <th>
            Calender
          </th>
          <td>
            <input type="text" name="date" id="my_date_picker" >
            <script>


         $(function() {
        $( "#my_date_picker" ).datepicker({
            maxDate:'+7d',
            minDate: '+0d',
             dateFormat: 'dd-mm-yy'



        });
        });

      </script>
          </td>
        </tr>
        <tr>
          <td>
            <input type="reset" value="Reset">
          </td>
          <td>
            <input type="submit" name="submit">
          </td>
        </tr>
      </table>
    </form>
        <%
                    if(null!=request.getAttribute("tablePrint"))
                    {
                        out.println(request.getAttribute("tablePrint"));
                    }

        %>

       </center>


    </body>
</html>