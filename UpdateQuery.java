import java.sql.*;

import java.io.*;

class UpdateQuery {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "kcbiradar";
            String password = "kcbiradar";
            String url = "jdbc:mysql://localhost:3306/xyz";

            Connection con = DriverManager.getConnection(url , user, password);

            String query = "update table1 set tName=? , tCity=? where tId=?";

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter new name : ");

            String name = br.readLine();

            System.out.println("Enter new city name : ");

            String city = br.readLine();

            System.out.println("Enter id : ");

            int id = Integer.parseInt(br.readLine());

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1 , name);
            pstmt.setString(2 , city);
            pstmt.setInt(3 , id);

            pstmt.executeUpdate();

            System.out.println("successfully updated!");

            con.close();

        } catch(Exception e) {
            System.out.println("Unable to connect check once code....\n");
            e.printStackTrace();
        }
    }
}