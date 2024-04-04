package Prepared;

import java.sql.*;

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
            String query = "INSERT INTO students(name, age, marks) VALUES (?,?,?)";
//            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,"Rehan");
            preparedStatement.setInt(2, 23);
            preparedStatement.setDouble(3,99.9);


//            String query = "INSERT INTO students(name, age, marks) VALUES(AAAnikta, 21, 76.55)";


            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected> 0){
                System.out.println("Data inserted successfully");
            }else {
                System.out.println("Not inserted Successfully");
            }
        }catch (SQLException ee){
            System.out.println(ee.getMessage());
        }

    }
}
