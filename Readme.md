POC of Selenium based framework in Java for E2E UI github.com sanity testing.


#### System requirements

* Java 21
* Maven

### Environment Setup

1. Make sure Java 21 SDK is installed and configured

2. Download dependencies:
    * Download [Maven](http://maven.apache.org/download.cgi)

3. **Environment configuration**:

    * Configure basic user providing github: username, password and token [token configuration helper](https://github.com/settings/tokens/new) in file  **src/main/resources/testData/users.json** folder.
    * **Important: Token has to have all repo and delete_repo permissions** 

#### Running from CLI:

```bash
$ mvn clean test
``` 

#### Resources

##### [TestNG Documentation](https://testng.org/)

##### [Java Documentation](https://docs.oracle.com/en/java/javase/21/index.html)



#### TODO: 

* Screenshot after failure
* Reporting tool - ex. Allure
* Run test in headless mode after adding two previous steps


#### Information: 

* Create account test is based on random data, can failed from time to time