import java.sql.*;
import java.util.*;

public class Main{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/shopini";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Gokul@#63808";

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        try {
            // Establish the database connection
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connected to the database!");

            while (true) {
                System.out.println("Welcome to the Shopping Bill Website");
                System.out.println("1. Login as Admin");
                System.out.println("2. Login as Agent");
                System.out.println("3. LogOut");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        loginAsAdmin(conn);
                        break;
                    case 2:
                        loginAsAgent(conn);
                        break;
                    case 3:
                        System.out.println("Thank you for using the Shopping Bill Website. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }


    

    private static void loginAsAdmin(Connection conn) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Admin Login");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        try {
            String query = "SELECT * FROM Login WHERE username = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Admin login successful!");
                 while (true) {
                    System.out.println("Admin Menu");
                    System.out.println("1. Add Product to Agent");
                    System.out.println("2. View Product Table Records");
                    System.out.println("3. Logout");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            addProductToTable(conn);
                            break;
                        case 2:
                            viewProductTableRecords(conn);
                            break;
                        case 3:
                            System.out.println("Admin logged out.");
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }

                    System.out.println();
                }
            } else {
                System.out.println("Admin login failed. Invalid username or password.");
            }
        } catch (SQLException e) {
            System.out.println("Error during admin login: " + e.getMessage());
        }
    }

    private static void loginAsAgent(Connection conn) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Agent Login");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        try {
            String query = "SELECT * FROM Login WHERE userName = ? AND passWord = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Agent login successful!");
                while (true) {
                    System.out.println("Agent Menu");
                    System.out.println("1. Add Product to Table");
                    System.out.println("2. Buy the Product");
                    System.out.println("3. Logout");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            addProductToTable(conn);
                            break;
                        case 2:
                            productSell(conn);
                            break;
                        case 3:
                            System.out.println("Agent logged out.");
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }

                    System.out.println();
                }
            } else {
                System.out.println("Agent login failed. Invalid username or password.");
            }
        } catch (SQLException e) {
            System.out.println("Error during agent login: " + e.getMessage());
        }
    }

  private static void addProductToTable(Connection conn) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Add Product");
        System.out.print("Enter Product ID: ");
        int pid = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter Product Name: ");
        String pname = scanner.nextLine();
        System.out.print("Enter Product Minimum-Sell-Quantity: ");
        int minimum_sellquantity = scanner.nextInt();
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Product Quantity: ");
        int quantity = scanner.nextInt();

        try {
            String query = "INSERT INTO Product (pid, pname,minimum_sellquantity, price, quantity) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, pid);
            statement.setString(2, pname);
            statement.setInt(3, minimum_sellquantity);
            statement.setDouble(4, price);
            statement.setInt(5, quantity);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Product added to Table successfully.");
            } else {
                System.out.println("Failed to add the product to Agent.");
            }
        } catch (SQLException e) {
            System.out.println("Error adding product to Agent: " + e.getMessage());
        }
    }

    private static void viewProductTableRecords(Connection conn) {
        try {
            String query = "SELECT * FROM Product";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int pid = resultSet.getInt("pid");
                String pname = resultSet.getString("pname");
                int minimum_sellquantity = resultSet.getInt("minimum_sellquantity");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");

                System.out.println("Product ID: " + pid);
                System.out.println("Product Name: " + pname);
                System.out.println("Product Minimum sell Quantity: " + minimum_sellquantity);
                System.out.println("Product Price: " + price);
                System.out.println("Product Quantity: " + quantity);
                System.out.println("-------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error viewing Agent table records: " + e.getMessage());
        }
    }
private static void productSell(Connection conn) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the Product Id");
    int pid = scanner.nextInt();
    System.out.println("Enter the Number of Quantity that You Want TO Buy");
    int buyQuantity = scanner.nextInt();
    try {
        String query = "SELECT price FROM Product WHERE pid = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, pid);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int price = resultSet.getInt("price");
            System.out.println("Your Total Product Cost is RS." + price * buyQuantity);
        } else {
            System.out.println("Invalid product Id");
        }
    } catch (SQLException e) {
        System.out.println("Error during product sell: " + e.getMessage());
    }
}

}
