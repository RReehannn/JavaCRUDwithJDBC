package Statements;

import java.sql.*;

public class Read {
    private static final String url= "jdbc:mysql://localhost:3306/myData" ;
    private static final String username = "root";
    private static final String password= "Rehan786@";


    public static void main(String[] args) {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "select * from students";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double marks = resultSet.getDouble("marks");
                System.out.println("Id: " + name);
                System.out.println("Age: " + age);
                System.out.println("Marks: " + marks);
            }


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}