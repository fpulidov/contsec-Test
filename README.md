# ContSec Login Test

This project has been developed to perform a test against [Continuum Security Irius Risk site](https://community.iriusrisk.com/#!login)


## Setting the project

### Setting maven

Download binary files from [here](https://maven.apache.org/download.cgi)

Unzip the files wherever you want (I personally prefer in C:/ or /home/{user})

You need to create several environment variables which point to this maven directory. These are:

```
M2_HOME -> Root directory of apache-maven (C:\apache-maven-3.5.3 for me)
M2 -> %M2_HOME%\bin
MAVEN_OPTS -> -Xms256m -Xmx512m
Add %M2% to Path variable
```


### Download dependencies


To download the dependencies you need to move to the root directory of the project (where pom.xml is locate) and launch "mvn package"

### Running the tests

To run the tests you just need to be in the root directory of the project (where pom.xml is located) and launch "mvn -Dtest=loginIT test"

### Test explanation

With the actual configuration the test will run correctly but it is prepared to log any error during the test process and to take a screenshot of the WebDriver before closing it for further information

