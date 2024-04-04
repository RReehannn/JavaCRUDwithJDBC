package Statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class Create {
    private static final String url= "jdbc:mysql://127.0.0.1:3306/myData";
    private static final String username="root";
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
            String query = String.format("INSERT INTO students(name, age, marks) VALUES('%s', %o, %f)", "Dhoni", 45, 37.6);

            int rowsAffected = statement.executeUpdate(query);
            if(rowsAffected> 0){
                System.out.println("Data inserted Successfully");
            }else {
                System.out.println("Data not inserted");
            }
        }catch (SQLException ee){
            System.out.println(ee.getMessage());
        }

    }
}
