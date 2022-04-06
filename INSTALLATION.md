#Crypto.com QA Challenges V1.0 Task and V2.2 Task installation guide.

**Steps to follow to setup API automation in local system:**

**Install Java: [Skip this step if already installed]**
- Check if Java is installed.
  - In terminal enter java -version to check if java is installed in the system.
  - In terminal enter javac -version to check if java compiler is installed in the system.
  - Any version of java greater than 1.8 is supported.
  - Check with API team in case a lower version is installed 
  - Install java development kit if not available.

**Install Eclipse : [Skip this step if already installed]** 
- Install eclipse if not available.
  - Download eclipse installer.
  - Run eclipse installer.
  - Select install eclipse for java developers.
  - Open workbench.

**Remember install TestNg from Eclipse Marketplace**
- Install testng
  - Open -> Help -> Eclipse Marketplace -> Search testng -> Install Testng for eclipse plugin -> Restart eclipse.
- Install or add dependency if need and add in to pom.xml

**Get Code base:**
  - Download my complete source
  - url : https://github.com/meta19Ken/Crypto.com
  - When I do this task, I take reference from following restassurredFramework
    - Clone restassuredFramework
      - url : https://github.com/sithik1994/restassuredFramework.git

**Run it**
- File -> Open Project from File System -> Browse the folder and open the project from the folder.
- Build the project by maven and choose build with "test".
- You can also use command line to run by typing "mvn test".

**Result**
- The Result will be generated in ./ExtentedReports/ExtentReportResults.html
