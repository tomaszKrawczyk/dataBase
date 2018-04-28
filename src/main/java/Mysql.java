import java.sql.*;

/**
 * Created by Tomek Krawczyk on 26.04.2018.
 */
public class Mysql {

    private static final String DB = "jdbc:mysql://5.135.218.27:3306/spring";
    private static final String USER = "oskar";
    private static final String USERPW = "wisla2000";
    private static final String DRIVER = "com.mysql.jdbc.Driver";


    public static void main(String[] args) {


//        try {
//            new com.mysql.jdbc.Driver();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


        try {
            Class.forName(DRIVER).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try
        {
            Connection connection= DriverManager.getConnection(DB,USER,USERPW);
            Statement statemen=connection.createStatement();

            /*statemen.execute("INSERT INTO user(username,password,role,gender)"+
                    "VALUES('SAD','SAAAD','admin','0')");

            statemen.close();
*/

            statemen.executeUpdate("UPDATE user SET username='krawcu' WHERE id='7'");
            statemen.close();


/*
            ResultSet resultSet=statemen.executeQuery("SELECT * FROM user");
            while (resultSet.next()){

                System.out.println("--------------------------------------");
                System.out.println(resultSet.getString("username"));

            }
            resultSet.close();*/



        } catch (SQLException e) {
            e.printStackTrace();
        }


        System.out.println("Jeśli wyżej nie ma błedu, to znaczy ze jest połączenie!");

    }

}
