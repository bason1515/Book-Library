# Book-Library
Cognifide - Java Homework 2019

This is a RESTful web application in with you can give a request to server via url and get appropriate response.

Project is base on Spring Boot that configurate Tomcat server by himself.

Before build and running make sure that you are in bookLibrary directory

<b>Building</b>
- To build the project use following command: `mvn clean install`

<b>Running</b>
- Application is runing on port 8080 so make sure it is not used at the time you run command belowe!
- After building the application run following command to start it: `java -jar target/bookLibrary-0.0.1-SNAPSHOT.jar`

you can call server for : 
- /isbn/{isbn}
- /category/{category}
- /rating  

where {} is your request
