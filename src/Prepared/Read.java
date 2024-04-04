package Prepared;

import java.sql.*;

class Read {
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
            String query = "SELECT marks from students WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 3);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                double marks = resultSet.getDouble("marks");
                System.out.println("Marks: " + marks);
            } else {
                System.out.println("Marks not found!! ");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}