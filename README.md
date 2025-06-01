
STEP 1: In Order to run this, clone the git repository.


    Repository: https://github.com/Neerajreddy28/student-gradle-app


STEP 2: change the directory to the project 


    Command: cd student-gradle-app/


STEP 3: once the directory is changed then enter run command


  For Mac: ./gradlew run


  For windows: ./gradlew.bat run


The current configuration displays student profiles for individuals aged 15 with marks exceeding 50, indicated by a "Build Successful" message upon execution.



To modify the search criteria and retrieve different student data, access the config.properties file. This file uses the following format:


Studentprofile,Age,Marks

For example, changing the line to Studentprofile,19,90 will filter results to display students aged 19 or older with marks of 90 or greater. Adjusting these values will accordingly update the student profiles fetched.









