package Prepared;

import java.sql.*;

class Update {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/myData";
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
            String query = "UPDATE students SET marks = ? WHERE id  = ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, 22.2);
            preparedStatement.setInt(2, 3);

            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected > 0) {
                System.out.println("Data Updated successfully");
            } else {
                System.out.println("Data not Updated");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}