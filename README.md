# Roman Numerals Converter - Services
For the code reviewers of Strata Health. This is the backend service of the Roman Numerals converter. This has one endpoint that can distinguish between converting to or from roman numerals. This is accomplished by determining if the user input has letters or numbers.

## System Requirements
- Netbeans 8.2 (Java & Glassfish Server)
	- Required to run the web server. We use this to take advantage of the preset template that Netbeans offers for running Java EE webservers.

## Install
- Open NetBeans 8.2 and import the project in the workspace (made possible by the `./nbproject` directory)
- Right click on the project name `roman-numerals-converter.service` and hit "Deploy"
	- This will deploy the web service to the local network

## Notes
- We follow the "Separation of Concern" pattern by exclusively making this project an API-only service so it has no front-end
- We access the front-end from the front-end repository

## Screenshots and Videos
#### Usage
[Video](https://github.com/JediahDizon/roman-numerals-converter.client/blob/master/assets/Test%20Case.MOV "Use Case")

#### JUnit Test
![Screenshot](https://github.com/JediahDizon/roman-numerals-converter.client/blob/master/assets/Test%20Result.png "JUnit Test")
