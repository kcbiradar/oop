import java.sql.*;

import java.io.*;

class SelectQuery {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "kcbiradar";
            String password = "kcbiradar";
            String url = "jdbc:mysql://localhost:3306/xyz";

            Connection con = DriverManager.getConnection(url , user, password);
            String query = "select * from table1";

            Statement stmt = con.createStatement();

            ResultSet set = stmt.executeQuery(query);

            System.out.println("Printing your database : ");

            while(set.next()) {
                int id = set.getInt(1);
                String name = set.getString(2);
                String city = set.getString(3);
                System.out.println("ID : " + id + " NAME : " + name + " CITY : " + city);

                System.out.println();
            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}