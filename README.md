[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)
[![Discord](https://img.shields.io/badge/Discord%20-purple.svg)](https://discordapp.com/users/1010436507976335410)
[![Linkedin](https://img.shields.io/badge/LinkedIn%20-blue.svg)](https://www.linkedin.com/in/gokul-hastrophil/)
[![Github](https://img.shields.io/badge/Github%20-gr.svg)](https://github.com/gokul-hastrophil/)




# SHOPINI

The Shopini is a Java-based console application that provides a user-friendly environment for product purchasing. It allows users to log in as an admin or agent, perform various tasks such as adding products to the agent, view the records in the product table, buying the products and generate a bill for it.

## Features

- Login: Users can log in as an admin or agent by providing their username and password.
- Admin Functionality: The admin role can add products to the agent table and view the records in the agent table.
- Agent Functionality: The agent role can perform specific tasks related to add product to the table, can buy the product and display the shopping bill.
- Database Integration: The application integrates with a MySQL database to store and retrieve data.
- User-friendly Environment: The application provides a menu-driven interface for easy navigation and interaction


## Getting-Started
To run the Shopping Bill Website, follow these steps:

1. Set up a MySQL database and update the database configuration details in the code.
2. Compile the Java source files using a Java compiler.
3. Execute the compiled Java program.

### Dependencies

- Java Development Kit (JDK)
- MySQL database

### Configuration

Make sure to update the following configuration details in the code:

- `DB_URL`: The URL of the MySQL database.
- `DB_USERNAME`: The username to access the database.
- `DB_PASSWORD`: The password to access the database.

### Usage

1. Launch the application.
2. Choose the appropriate login option: admin or agent.
3. Provide the correct username and password.
4. Perform the desired actions based on the available menu options.
5. Logout when finished.


## Demo

![ezgif com-video-to-gif](https://github.com/gokul-hastrophil/Shopini/assets/65296673/bfc11550-e37c-4b70-b2ad-355ff2ce100d)



## Run Locally

Clone the project

```bash
  git clone https://github.com/gokul-hastrophil/Shopini/
```

Go to the project directory

```java
// Code snippet demonstrating the usage of the application

public class ShoppingBillWebsite{
    public static void main(String[] args) {
        Main m = new Main();
        m.main();
    }
}
```
## Contributing

Contributions are welcome! If you have any ideas, improvements, or bug fixes, please open an issue or submit a pull request.
## Authors

 [@GOKUL PRASANTH](https://www.github.com/gokul-hastrophil)


## Tech Stack

**Client:** Java, JDBC

**Server:** MySQL

