
# AlaTooItSphere CTF  🔴🔵

Welcome to the official repository for the AlaTooITClub's Capture The Flag (CTF) web service. This web service is designed to host CTF competitions, allowing users to engage in cybersecurity challenges in a robust and user-friendly environment. Built with Spring Boot and Thymeleaf, this platform supports a range of CTF challenges that can be easily managed and scaled.

## Features

- **User Authentication:** Secure login and registration system.
- **Challenge Interface:** A wide range of cybersecurity challenges from various categories.
- **Real-time Scoreboard:** Live updates of team scores and rankings.
- **Admin Panel:** For challenge management and user moderation.

## Prerequisites

Before you begin, ensure you have the following installed on your system:
- Java JDK 11 or newer
- Maven 3.6 or higher
## Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/AlaTooITClub/ctf-web-service.git
   cd ctf-web-service
   ```
2. **Install the required dependencies.**
   Navigate to the project directory and use Maven to install the dependencies:
   ```bash
   mvn clean install
    ```
3. **Set up your PostgreSQL database**
    ```
    CREATE DATABASE ctf_db;
   ```
4. **Run the application**  
    ```
    mvn spring-boot:run
    ```
