import java.sql.*;

import java.io.*;

class InsertQuery {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "kcbiradar";
            String password = "kcbiradar";
            String url = "jdbc:mysql://localhost:3306/xyz";

            Connection conn = DriverManager.getConnection(url , user , password);

            // create a query for inserting

            String query = "insert into table1(tName , tCity) values(? , ?)";

            // get PreparedStatement object

            PreparedStatement pstmt = conn.prepareStatement(query);

            // taking user input

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter your name");

            String name = br.readLine();

            System.out.println("Enter your city name");

            String city = br.readLine();

            // set the values to query
            pstmt.setString(1 , name);
            pstmt.setString(2 , city);

            pstmt.executeUpdate();

            System.out.println("inserted\n");

        } catch(Exception e) {
            System.out.println("Unable to connect check your code once");
            e.printStackTrace();
        }
    }
}