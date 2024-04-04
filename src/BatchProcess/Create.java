package BatchProcess;

import java.sql.*;
import java.util.Scanner;

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
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter name ");
                String name = scanner.next();
                System.out.print("Enter age: ");
                int age = scanner.nextInt();
                System.out.print("Enter marks: ");
                double marks = scanner.nextDouble();

                System.out.print("Please, Enter more Data(Y/N)");
                String choice = scanner.next();
                String query = String.format("INSERT INTO students (name, age, marks) VALUES('%s', %d, %f)", name, age, marks);
                statement.addBatch(query);
                if (choice.toUpperCase().equals("N")) {
                    break;
                }
            }
            int[] arr = statement.executeBatch();

        }catch (SQLException ee){
            System.out.println(ee.getMessage());
        }

    }
}
