import java.sql.*;
import java.util.Scanner;

class Create_T {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/lenden";
    private static final String username = "root";
    private static final String password = "Rehan786@";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String debitQuery = "UPDATE accounts set balance = balance  - ? where account_number = ? ";
            String creditQuery = "UPDATE accounts set balance = balance  + ? where account_number = ?";
            PreparedStatement debitPreparedStatement = connection.prepareStatement(debitQuery);
            PreparedStatement creditPreparedStatement = connection.prepareStatement(creditQuery);
            Scanner scanner = new Scanner(System.in);
            double amount = scanner.nextDouble();
            debitPreparedStatement.setDouble(1, amount);
            debitPreparedStatement.setInt(2, 101);
            creditPreparedStatement.setDouble(1, amount);
            creditPreparedStatement.setInt(2, 102);

//           if (isSufficient(connection, 101, amount)){
//               int affectedRows1 = debitPreparedStatement.executeUpdate();
//               int affectedRows2 = creditPreparedStatement.executeUpdate();
//           } else {
//               System.out.println("Insufficient Balance ");
//           }
            debitPreparedStatement.executeUpdate();
            creditPreparedStatement.executeUpdate();


        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
    }


    static boolean isSufficient(Connection connection, int account_number, double amount) {
        try {
            String query = "SELECT balance FROM accounts WHERE account_number = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, account_number);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                double current_balance = resultSet.getDouble("balance");
                if (amount > current_balance) {
                    return false;
                } else {
                    return true;
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

}


