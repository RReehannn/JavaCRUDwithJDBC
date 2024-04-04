package Prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class Delete {
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
            String query = "DELETE FROM students WHERE id  = ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, 1);

            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected > 0) {
                System.out.println("DELETE successfully");
            } else {
                System.out.println("not DELETED ");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}