package Statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class Delete {
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
            String query = "DELETE FROM students WHERE id = 2 ";

            int rowsAffected = statement.executeUpdate(query);
            if(rowsAffected> 0){
                System.out.println("Deleted Successfully");
            }else {
                System.out.println("Not Deleted Successfully");
            }
        }catch (SQLException ee){
            System.out.println(ee.getMessage());
        }

    }
}
