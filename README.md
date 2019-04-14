# Roman Numerals Converter - Services
For the code reviewers of Strata Health. This is the backend service of the Roman Numerals converter. This has one endpoint that can distinguish between converting to or from roman numerals. This is accomplished by determining if the user input has letters or numbers.

## Install
Not interested in web servers? Just run the included `./dist/index.html` file and you should be good to go.

Still here? You can run the following commands in a command line terminal starting from the root of the project:
- `npm install`
	- This will install the dependencies required to run the front-end project

- `npm run serve`
	- This will serve the website and it can be accessed through `http://localhost/`

## System Requirements
- Node JS
	- Required to run the web server

## Notes
- Validation and calculated values comes from the backend
- Any changes to the input box is sent to the server to be calculated. Only happens every half a second of input inactivity.

## Screenshots and Videos
#### Usage
![Video](https://github.com/JediahDizon/roman-numerals-converter.client/blob/master/assets/Test%20Case.MOV "Use Case")

#### JUnit Test
![Screenshot](https://github.com/JediahDizon/roman-numerals-converter.client/blob/master/assets/Test%20Result.png "JUnit Test")
