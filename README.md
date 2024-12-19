# Demo SMS Application

## Overview
`Demo SMS` is a Spring Boot application designed to send SMS messages using the **Twilio API**. The application provides a simple mechanism to integrate with Twilio for sending outbound SMS messages efficiently.

This project integrates key capabilities such as:
- Sending SMS using the Twilio platform.
- Configurable Twilio credentials and outgoing SMS number.
- Actuator support for monitoring the application's health and metrics.

## Features

- **Send SMS**: Easily send messages to any phone number using Twilio's APIs.
- **Integrated Spring Boot Actuator**: Access application metrics and health endpoints.
- **Environment Configuration**: Customize Twilio credentials and other parameters via environment variables or configuration files.
- **Built on Modern Java (21)**: Ensures compatibility with the latest features of the Java programming language.

## Key Technologies

This project is built using the following technologies:
- **Spring Boot 3.4.0**: For rapid application development.
    - Spring Boot Starter for Web Development.
    - Spring Boot Actuator for application monitoring.
- **Twilio Java SDK 10.6.4**: For interacting with the Twilio REST API.
- **Lombok**: Reduces boilerplate code for POJOs.
- **Java 21**: Fully utilizes modern Java programming features.
- **Maven**: Dependency management and project build tool.

## Requirements

The following tools are required to build and run the project:

- **Java SDK 21**: Ensure Java 21 is installed and set up in your development environment.
- **Twilio Account**: Create an account on [Twilio](https://www.twilio.com/) to obtain:
    - `Account SID`
    - `Auth Token`
    - Outgoing Phone Number.
- **Maven**: Installed for dependency management.

## Setup Instructions

### 1. Clone the Repository
Clone the project repository to your local machine:
```shell script
git clone https://github.com/yourusername/demo-sms.git
cd demo-sms
```

### 2. Configure Application Properties
Update the application's **Twilio** configurations. These can be set in the `application.properties` file or environment variables.

#### Configurable Parameters
In `application.properties`:
```properties
spring.application.name=demo-sms
server.port=8084
TWILIO_ACCOUNT_SID=YOUR_ACCOUNT_SID
TWILIO_AUTH_TOKEN=YOUR_AUTH_TOKEN
OUTGOING_SMS_NUMBER=+1234567890
```

Or via environment variables:
- `TWILIO_ACCOUNT_SID`: Your Twilio account SID.
- `TWILIO_AUTH_TOKEN`: Your Twilio authentication token.
- `OUTGOING_SMS_NUMBER`: Twilio-recommended outgoing phone number, capable of sending SMS.

### 3. Build the Application
Build the application using Maven:
```shell script
mvn clean install
```

### 4. Run the Application
Run the application with:
```shell script
mvn spring-boot:run
```
Or execute the generated JAR file:
```shell script
java -jar target/demo-sms-0.0.1-SNAPSHOT.jar
```

By default, the application runs on port **8084**. You can access it at:
```
http://localhost:8084
```

## Usage

### Sending SMS
The application provides an API endpoint to send messages. Here's how you can send an SMS using the endpoint (example provided for Postman):

#### API Endpoint
- **URL**: `POST /sms/send`
- **Headers**: `Content-Type: application/json`
- **Body** (example):
```json
{
    "destinationSmsNumber": "+1234567890",
    "smsMessage": "Hello! This is a test message from the Demo SMS app."
}
```

### Responses
- **200 OK**: SMS sent successfully.
- **400 Bad Request**: Invalid input or Twilio configuration error.

### Viewing Application Metrics
Spring Boot Actuator exposes essential metrics for system monitoring. Check the following:
- **Health Check**: `GET /actuator/health`
- **Other Endpoints**: Enabled based on your Actuator configuration.

## Testing

### Running Tests
The application includes unit tests and integration tests for specific components. Use the following command to execute all tests:
```shell script
mvn test
```

## File Structure
Below is the project structure for better understanding:

```
demo-sms/
│
├── src/main/java/com/rca/demo_sms
│   ├── SmsController        # APIs and request mapping layer
│   ├── SmsService           # SMS logic (e.g., integration with Twilio SDK)
│   ├── SMSSendRequest            # Application configurations
│    
│
├── src/main/resources
│   ├── application.properties    # Configuration file for the application
├── pom.xml                # Project Object Model (Maven configuration)
```

## Dependencies

The project uses these main dependencies:
- **Spring Boot Starter Web**: To build a REST-based application.
- **Twilio SDK**: Integration with Twilio services for SMS.
- **Spring Boot Starter Actuator**: Adds monitoring endpoints.
- **Lombok**: Reducing boilerplate in Java.
- **Spring Boot Starter Test**: Essential for unit and integration testing.

## Twilio Setup Instructions

To get started with Twilio:
1. Create a free account at [Twilio](https://www.twilio.com/).
2. Obtain a trial account SID, Auth Token, and a phone number capable of sending SMS.
3. Add these to your environment variables or `application.properties`.

### Twilio Trial Restrictions
If using a trial account, remember that:
- You can only send messages to verified numbers.
- Outgoing messages will include a "Sent from your Twilio trial account" prefix.

## Future Enhancements
- Implement support for MMS (multimedia messages).
- Add user authentication for more secure SMS sending.
- Enable scheduling for delayed message delivery.

## Contribution Guidelines

We welcome contributions! Follow these steps:
1. Fork the repository.
2. Create a feature branch: `git checkout -b feature/feature-name`.
3. Make your changes and commit: `git commit -m "Add some feature"`.
4. Push to the branch: `git push origin feature/feature-name`.
5. Submit a pull request for review.

## License

This project is licensed under the [MIT License](LICENSE). Feel free to use and modify it as per your needs.

## Contact

For questions or support, reach out to:
- **Author**: Yves HAKIZIMANA
- **Email**: yvhakizimana123@gmail.com
- **GitHub**: github.com/yvesHakizimana

