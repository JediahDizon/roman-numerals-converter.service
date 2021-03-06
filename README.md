# Roman Numerals Converter - Services
For the code reviewers of Strata Health Solutions. This is the backend service of the Roman Numerals converter. This has one endpoint that can distinguish between converting to or from roman numerals. This is accomplished by determining if the user input has letters or numbers.

Frontend: https://github.com/JediahDizon/roman-numerals-converter.client

## System Requirements
- Netbeans 8.2 (Java EE & Glassfish Server)
	- Required to run the web server. We use this to take advantage of the preset template that Netbeans offers for running Java EE webservers.

## Install
- Open NetBeans and import the `Web Application` project in the workspace (made possible by the `./nbproject` directory)
- If that does not work, create new project with `Java Web > Web Project with Existing Sources` and point the sources to the project directory
- Right click on the project name `roman-numerals-converter.service` and hit "Deploy"
	- This will deploy the web service to the local network

## Testing
Using Netbeans' built-in JUnit testing feature, we simply open `Test Packages/services/RomanNumeralConverterTest.java` from the project workspace and hit `Run` > `Test Project` from the toolbar.

## Notes
- We follow the "Separation of Concern" pattern by exclusively making this project an API-only service so it has no front-end
- We access the front-end from the front-end repository

## Screenshots and Videos
#### Usage
[Download Video Footage](https://github.com/JediahDizon/roman-numerals-converter.client/blob/master/assets/Test%20Case.MOV?raw=true "Video Footage")

#### JUnit Test
![Screenshot](https://github.com/JediahDizon/roman-numerals-converter.client/blob/master/assets/Test%20Result.png "JUnit Test")
