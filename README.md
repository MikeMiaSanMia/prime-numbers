This is a project called prime-numbers.

Goal of this application is to get data in JSON format from REST application and process them to get unique and sorted with ascending order prime numbers.

Results are presented in two ways:
- as option for displaying new data in command line
- as chart where on X-axis is consecutive number for prime number (from 1 to size of result) and on Y-axis is prime number value (if first prime number is 2 - there will be number 1 on X-Axis and value 2 on Y-Axis)

Displaying part was done with JFreeChart which was embedded in Swing GUI. Additionally button with name "Hello button" was added but it only displays message "Hello" in command line. First idea was to manage sessions via this button which name would be "Next session" then. But because lack of time I have resigned from this functionality.
Application is managed from command line. 
User has 2 options:
- when user enters: 1 - new data from next session with server is displayed
- when user enters: 0 - application is closed, Scanner stream is closed, whole Swing applications from all sessions are closed

This is Maven project. It uses dependencies:
- org.json.simple for JSON data processing
- resteasy-client for resolving problem with JAX-RS 2.0
- JUnit5 and Mockito for unit testing
- JFreeChart for displaying application result in form of chart
- application uses JAX-RS 2.0 for communication with server