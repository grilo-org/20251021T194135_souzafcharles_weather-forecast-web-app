![GitHub language count](https://img.shields.io/github/languages/count/souzafcharles/Weather-Forecast-Spring-Boot-Thymeleaf)
![GitHub top language](https://img.shields.io/github/languages/top/souzafcharles/Weather-Forecast-Spring-Boot-Thymeleaf)
![GitHub](https://img.shields.io/github/license/souzafcharles/Weather-Forecast-Spring-Boot-Thymeleaf)
![GitHub last commit](https://img.shields.io/github/last-commit/souzafcharles/Weather-Forecast-Spring-Boot-Thymeleaf)

# Weather Forecast Web Application


## Page Views:

The following section presents the main user interfaces of the Weather Forecast Web Application. Each screenshot illustrates the interaction flow, from entering a city name to viewing detailed weather data or handling errors.

## Home Screen – Empty Input:

This is the initial view displayed when the user accesses the application. The input field for entering the city name is empty, awaiting user input.

![Home Screen Empty Input](https://github.com/souzafcharles/Weather-Forecast-Spring-Boot-Thymeleaf/blob/main/local/screen01.png)

## Home Screen – City Name Entered:

Once the user begins typing a city name, the input field captures the text, ready for submission to retrieve weather data.

![Home Screen With Input](https://github.com/souzafcharles/Weather-Forecast-Spring-Boot-Thymeleaf/blob/main/local/screen02.png)

## Weather Results Display:

After submitting a valid city name, the application displays the weather forecast including city, country, temperature, humidity, wind speed, description, and an appropriate weather icon.

![Weather Results](https://github.com/souzafcharles/Weather-Forecast-Spring-Boot-Thymeleaf/blob/main/local/screen03.png)

## Error Message Display:

If an invalid city name is entered or the API fails to return data, the application shows a user-friendly error message indicating the issue.

![Error Message](https://github.com/souzafcharles/Weather-Forecast-Spring-Boot-Thymeleaf/blob/main/local/screen04.png)

---

## Introduction

<p align="justify">
This web application was developed using the <code>Java Spring Boot</code> framework and provides a dynamic interface for retrieving real-time weather information for any city worldwide. By integrating with the public <a href="https://openweathermap.org/" target="_blank">OpenWeather API</a>, the system allows users to access comprehensive meteorological data, including temperature, humidity, wind speed, and a descriptive overview of current weather conditions. The application emphasises responsiveness and usability by employing <code>Thymeleaf</code> templates for the frontend and <code>Bootstrap</code> for styling and layout.
</p>

<p align="justify">
The system architecture is organised according to a layered design, encompassing <code>Controller</code>, <code>Service</code>, and client components. The <code>WeatherViewController</code> manages user interactions and page rendering, whereas the <code>WeatherController</code> exposes a RESTful endpoint for external consumption of weather data in JSON format. The <code>WeatherService</code> encapsulates business logic and orchestrates communication with the <code>OpenWeatherClient</code>, which leverages <code>Spring WebClient</code> to perform asynchronous HTTP requests to the external API. Incoming API responses are mapped into internal entities through a dedicated <code>WeatherMapper</code>, ensuring a clean separation of concerns and data consistency.
</p>

<p align="justify">
Environmental configuration and sensitive data management are handled through the use of a <code>Dotenv</code> utility, allowing API keys and other parameters to be securely loaded into the system at runtime. Validation of user input is enforced using <code>Jakarta Validation</code> annotations, guaranteeing the integrity of the city parameters provided by users. Visual representation of the weather is enhanced through a utility that translates textual weather descriptions into corresponding <code>Weather Icons</code> CSS classes, creating an intuitive and engaging user experience. The frontend integrates interactive elements with <code>jQuery</code> and <code>Bootstrap</code> scripts, while custom CSS ensures aesthetic consistency across pages.
</p>

<p align="justify">
Overall, this application demonstrates a fully functional integration between a <code>Java Spring Boot</code> backend and an external API, incorporating best practices in web application development, asynchronous HTTP communication, template-driven rendering, and secure configuration management. It serves as a practical example of how external services can be seamlessly consumed, processed, and presented to end-users in a structured, maintainable, and visually appealing manner.
</p>

---

## 2. Project Stack

| Technology              | Version   | Description                                                                 |
|-------------------------|-----------|-----------------------------------------------------------------------------|
| ☕ Java                 | `21`      | Backend programming language                                                |
| 🌱 Spring Boot          | `3.5.6`   | Core framework for building backend services                                |
| 🌐 Spring Web           | `3.5.6`   | Enables development of RESTful web applications using Spring MVC           |
| 🌱 Spring WebFlux / WebClient | `3.5.6` | Provides reactive programming support and non-blocking HTTP client for external API integration |
| 📝 Jakarta Validation   | `3.5.6`   | Supports validation of user input through annotations                       |
| 🌿 Dotenv Java          | `3.2.0`   | Loads environment variables such as API keys securely at runtime            |
| 💾 Spring Boot Thymeleaf| `3.5.6`   | Template engine for rendering dynamic HTML content                          |
| 🐦 Maven                | `3.9.x`   | Build automation and dependency management tool                             |

---

## Dependencies

| Dependency                    | Category          | Description                                                                                                     |
|-------------------------------|------------------|-----------------------------------------------------------------------------------------------------------------|
| 🌐 Spring Web                 | Web              | Builds web applications, including RESTful APIs, using Spring MVC. Uses Apache Tomcat as the default container. |
| 🌱 Spring WebFlux / WebClient | Web / Reactive   | Provides reactive programming support and non-blocking HTTP client for consuming external APIs.                  |
| ✔️ Validation                 | Validation (I/O) | Enables Java Bean Validation using Jakarta Validator to ensure input integrity.                                   |
| 🌿 Dotenv Java                | Configuration    | Allows secure loading of environment variables at runtime, such as API keys.                                     |
| 💾 Spring Boot Thymeleaf      | Frontend / UI    | Renders dynamic HTML templates and integrates seamlessly with backend data.                                       |

---

## 3. Architecture & Design Patterns

<p align="justify">
The Weather Forecast Web Application follows a <strong>Layered Architecture</strong> composed of <code>Controller → Service → Client → External API</code>. This design ensures modularity, separation of concerns, and scalability, allowing the system to efficiently handle both user interactions and asynchronous API communications.
</p>

<p align="justify">
The <strong>Controller Layer</strong> is divided into two components: the <code>WeatherController</code> provides RESTful endpoints for programmatic access to weather data, while the <code>WeatherViewController</code> manages the rendering of HTML templates via <code>Thymeleaf</code> and handles user input from the web interface. The <strong>Service Layer</strong> implements the core business logic, orchestrating the retrieval of weather data and converting external API responses into internal <code>WeatherData</code> entities using the <code>WeatherMapper</code>. The <strong>Client Layer</strong> utilises <code>Spring WebClient</code> to perform asynchronous requests to the <a href="https://openweathermap.org/" target="_blank">OpenWeather API</a>, handling errors and response mapping efficiently.
</p>

<p align="justify">
Key design patterns employed include the <strong>DTO Pattern</strong> to decouple internal entities from the external API contracts, and a <strong>Utility Pattern</strong> exemplified by the <code>WeatherIconUtils</code> class, which translates textual weather descriptions into icon representations for the frontend. Input validation is enforced through <code>Jakarta Validation</code> annotations, ensuring the integrity of user-submitted data. Environment management is facilitated by the <strong>Configuration Loader Pattern</strong> implemented in the <code>LoadEnvironment</code> class, allowing secure access to API keys at runtime. The architecture overall promotes maintainability, testability, and clear separation between the backend logic, external API integration, and presentation layer.
</p>

---

## 4. Algorithms & Business Logic (Method Explanations)

<p align="justify">
This section provides a detailed overview of the core methods implemented within the <code>WeatherService</code> and related components, which encapsulate the primary business logic for weather data retrieval, processing, and presentation.
</p>

<p align="justify">
The <code>getWeather(String city)</code> method in <code>WeatherService</code> orchestrates the entire process of obtaining weather information for a given city. It calls the <code>OpenWeatherClient</code> to perform an HTTP GET request via <code>WebClient</code> to the <a href="https://openweathermap.org/" target="_blank">OpenWeather API</a>, passing the city name and API key as parameters. The client method handles potential exceptions such as <code>WebClientResponseException</code>, ensuring robust error management and preventing propagation of API errors to the user interface. Upon receiving the API response as a <code>WeatherResponseDTO</code>, the <code>WeatherMapper.toEntity()</code> method transforms the DTO into an internal <code>WeatherData</code> entity, extracting relevant fields such as temperature, humidity, wind speed, and textual weather descriptions.
</p>

<p align="justify">
Within the frontend workflow, the <code>WeatherViewController.displayWeather(String city, Model model)</code> method leverages the <code>WeatherService</code> to retrieve the mapped entity and populate model attributes for the <code>Thymeleaf</code> template. It also employs the <code>WeatherIconUtils.getWeatherIcon(String description)</code> utility to map descriptive weather text into corresponding CSS classes for icon representation. The method includes exception handling to display user-friendly error messages if the city is not found or if the API request fails.
</p>

<p align="justify">
The <code>LoadEnvironment.loadEnv()</code> method provides a configuration utility pattern that securely loads environment variables from a <code>.env</code> file into the system properties at application startup, ensuring that sensitive information such as API keys is not hard-coded. Combined with <code>Jakarta Validation</code> annotations in the <code>WeatherRequestDTO</code>, this guarantees that user input conforms to expected formats before processing.
</p>

<p align="justify">
Overall, these methods collectively implement a clear separation of concerns between API consumption, data transformation, and presentation logic. They exemplify a reactive, modular approach to building a web application capable of delivering real-time, accurate weather information while maintaining maintainability, testability, and user-friendly feedback.
</p>

---

## 5. Unit Testing & Test Architecture

<p align="justify">
The Weather Forecast Web Application employs comprehensive unit testing to ensure the correctness and reliability of its components. Tests are implemented using <strong>JUnit 5</strong> for the testing framework and <strong>Mockito</strong> for mocking dependencies, enabling isolated testing of each layer of the application without requiring actual external API calls.
</p>

<p align="justify">
The testing strategy follows the <strong>Arrange-Act-Assert (AAA)</strong> pattern. In the <em>Arrange</em> phase, test data, mocks, and expected responses are prepared. The <em>Act</em> phase invokes the method under test, while the <em>Assert</em> phase verifies the output and interactions with dependencies. This structured approach provides clarity, maintainability, and consistent testing practices.
</p>

<p align="justify">
Unit tests are implemented across multiple layers of the application. For the <strong>OpenWeatherClient</strong>, mocks of <code>WebClient</code> and related request/response specifications simulate API calls, ensuring the client correctly constructs URIs, handles responses, and maps data to <code>WeatherResponseDTO</code>. The <strong>WeatherService</strong> is tested to verify that it correctly transforms the DTO into a <code>WeatherData</code> entity and delegates API calls to the client. REST endpoints in the <strong>WeatherController</strong> are tested to ensure that returned data matches expected values and that service methods are correctly invoked. Finally, the <strong>WeatherViewController</strong> tests confirm that model attributes are properly populated for <code>Thymeleaf</code> templates and that error handling displays appropriate messages when exceptions occur.
</p>

<p align="justify">
This thorough testing approach guarantees that individual components behave as expected, promotes early detection of defects, and reinforces confidence in the application’s stability and correctness. By isolating dependencies with Mockito and systematically applying the AAA pattern, the tests also document expected behaviour, supporting future maintenance and feature extensions.
</p>

---

## 6. Running Locally

6.1. Clone the repository:
```bash
git clone https://github.com/souzafcharles/Weather-Forecast-Spring-Boot-Thymeleaf.git
cd Ghibli-Studio-API-SpringBoot
```

6.2. Build the project using Maven:
```bash
mvn clean install
```

6.3. Run the Spring Boot application:
```bash
mvn spring-boot:run
```

---

## 7. Conclusion

<p align="justify">
This project implements a backend and frontend system integrating with the <strong>OpenWeather API</strong>, achieving the core objectives of the Weather Forecast Web Application. It provides real-time weather data for any city worldwide, combining dynamic data retrieval, mapping, and presentation in a user-friendly interface.
</p>

<p align="justify">
Key achievements:
</p>

<ul>
  <li><strong>External API Integration</strong> using <code>Spring WebClient</code>, with robust error handling and transformation of API responses into internal <code>WeatherData</code> entities.</li>
  <li><strong>Business Logic & Data Processing</strong> to ensure accurate mapping of weather descriptions, temperature, humidity, and wind speed, with utility support for weather icon representation.</li>
  <li><strong>Layered Architecture & Design Patterns</strong> promoting modularity, clarity, and maintainability through <code>Controller → Service → Client → External API</code> structure, along with DTO and utility patterns.</li>
  <li><strong>Frontend Integration & Presentation</strong> with <code>Thymeleaf</code> templates, <code>Bootstrap</code> styling, and dynamic content rendering, ensuring an intuitive and responsive user experience.</li>
  <li><strong>Environment & Input Management</strong> using <code>dotenv-java</code> for secure API key loading and <code>Jakarta Validation</code> annotations for input integrity.</li>
</ul>

<p align="justify">
This solution demonstrates effective integration of third-party APIs, structured backend logic, and responsive frontend presentation. It establishes a solid foundation for future enhancements including extended error handling, additional weather analytics, automated testing, and multi-language support.
</p>
