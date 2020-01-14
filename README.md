# RestAPITest
Testing Restful booking API, it consists of a simple booking-controller that allows you to create, update, delete and view existing bookings.

## Getting Started

The project can be cloned from GitHub. Since it is a maven project, all the dependencies will be imported easily on your local machine for the enhancing the development and test.

### Prerequisites and Installation

```
Java installation should be done and added to the PATH. Beside of this MAVEN_HOME should be added to the path. 
Also, Java IDE. I have used IntelliJ Community Edition 2019, but you can choose an IDE whatever you want. For example, Eclipse.
Please note that, after cloning the repository there will be a Jenkins_Configuration.rar file located in the root. This file includes all the required configuration, and you should import this file to create a job the same as me. 
Note: JDK version: jdk1.8.0_211
```

## Running the tests

### Jenkins:
Please read this blog post [Build a maven project to run test](https://medium.com/@anusha.sharma3010/build-a-simple-maven-project-in-jenkins-da7a2a4ae202)

### TestNG: 
* Goto Edit Configuration and set the project as TestNG project.
### Maven: 
* Goto project root folder and for running all tests
```
mvn clean test
```
* for running all tests in a class
```
mvn -Dtest=BookingTest clean test
```
* for a running single test
```
mvn -Dtest=BookingTest#getAllBookings clean test
```

### Project Structure
```
- API: 
- Payloads: 
- Test: API tests in order to verify the functionality of the API
```


## Built With

* [JAVA](https://docs.oracle.com/javase/8/docs/technotes/guides/language/index.html) - Programming Language
* [TestNG](https://testng.org/doc/) - The testing framework
* [RESTAssured](http://rest-assured.io/) - It is for testing and validating REST services in Java
* [Maven](https://maven.apache.org/) - It is a build automation tool used for Java projects
* [Jenkins](https://jenkins.io/) - It is an open source automation server to build the job periodically with required plugins




## Methods
``` 
1. Behaviour Driven Development
``` 

## Authors

* **Ali Pala** - *See the all repositories* - [Ali Pala](https://github.com/alipala)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* [Jenkins Job migration](https://staxmanade.com/2015/01/how-to-migrate-a-jenkins-job-to-new-jenkins-server/) - Please have a look how to migrate Jenkins job to your local. 


