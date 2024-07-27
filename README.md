# Orange-HRM

# Automation QC Engineer Assessment Solution

## Overview

This project provides an automated solution for the "Automation QC Engineer Assessment" task using Cucumber and Selenium for Java. The task involves automating a series of steps on the OrangeHRM demo website, including logging in, adding a user, and verifying the changes. Additionally, a bonus task involves interacting with the site's APIs using Rest Assured.

## Project Structure

The project follows the Page Object Model (POM) design pattern to enhance maintainability and readability. The structure of the project is as follows:

```
project-root
│   README.md
│   pom.xml
└───src
    └───main
    │   └───java
    │       └───pageobjects
    │       └───steps
    └───test
        └───java
            └───runners
            └───steps
            └───resources
                └───features
```

## Prerequisites

Before you begin, ensure you have the following installed on your local machine:

- Java JDK (version 8 or higher)
- Maven
- Git

## Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/automation-qc-engineer-assessment.git
   cd automation-qc-engineer-assessment
   ```

2. **Install dependencies:**

   ```bash
   mvn clean install
   ```

## Running Tests

To run the Cucumber tests, execute the following command in the terminal:

```bash
mvn test
```

## Features

### 1. User Management Automation

The primary feature of this project automates the following steps on the OrangeHRM demo website:

1. Navigate to the OrangeHRM demo site.
2. Log in with the provided credentials.
3. Navigate to the Admin tab.
4. Retrieve and verify the number of records.
5. Add a new user and save.
6. Verify the number of records increased by one.
7. Search for the new user.
8. Delete the new user.
9. Verify the number of records decreased by one.

**Author:** Mina Youssef  
**Email:** minacfs47@gmail.com  
**GitHub:** [MinaYoussif47](https://github.com/MinaYoussif47)