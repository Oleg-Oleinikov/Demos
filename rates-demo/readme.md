## Demo project for utilizing some of ShipTime API calls

The project is based on the Spring Boot framework and configured by Maven.
The template engine Thymeleaf was also used to implement the UI part.

### Run the project

* A pre-built executable JAR file (rates-demo-1.0.jar) as well as the task description document are saved in the project's root folder (just in case).
* Use Maven's "install" command to produce a new executable copy.
* The main class to run the application: org.alohome.rates.RatesDemoApp.java
* The application is based on the port 8087
* The starting point is the page with initial data form. It is available at the root resource: localhost:8087

### Project implementation description

* The initial data are pre-populated in the form to save time while testing.
* Some non-required API fields are missing in the model classes for this demo.
* I have decided not to use the Spring Reactor and its WebClient. The API client functionality covered by vanilla RestTemplate class.
* The RatesController supports the initial data form display (/) and calls for rate quotes (/rates).
* The ShipmentsController creates a shipment (/shipments) and downloads the label PDF (/label). I decided to create the /label endpoint,
because the direct attempt to get a label PDF file requires authentication in browser.
* The HTML files in the template directory represent the UI forms to enter initial data and select a quote from list.
* The required credentials (from the task document) are retrieved from the application.properties file.
* Quote sorting was implemented in a standard way using the interface Comparable and the method Collections.sort.
* Assuming multiple tracking numbers, they are displayed using the standard toString method. I got always one tracking number during my tests.
* The Selected.java class was added due to some limitations in Thymeleaf. It returns the selected quote to the controller.

### Other comments and restrictions

Considering this project as a demo, I made some assumptions and limitations:
* Some of required request parameters were hardcoded, as it is allowed in the task description, directly in classes as property default values.
* The endpoint mapping methods return a resulted String for Thymeleaf, except the one for retrieving a PDF.
* Model's getters and setters were implemented traditionally. Lombok requires to be manually installed to the Eclipse.
This sometimes gives artifacts in a regular work with Eclipse.
* For this simple project I decided to store some parameters in session, so this is not a 100% rest application.  
* Having Thymeleaf for UI rendering, all the endpoints return 200 as a result. Perhaps it is possible to configure Thymeleaf to react to non-200 results (I have no experience with Thymeleaf).
* I implemented the UI error handling on the same UI pages with data. The errors are displayed at the top of page. This allows to update source data and retry the request.
* Lack of Thymeleaf knowledge did not allow me to implement any error handling in the /label endpoint. Thymeleaf does not want to accept any non-text response.