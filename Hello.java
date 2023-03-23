import java.sql.*;

class Hello {
    public static void main(String[] args) {
        System.out.println("\n Connection establishing\n");
        try {
            // load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String user = "kcbiradar";
            String url = "jdbc:mysql://localhost:3306/xyz";
            String password = "kcbiradar";
            //creating connection
            Connection con = DriverManager.getConnection(url , user, password);

            // writing the query

            String q = "create table table1(tId int(20) primary key auto_increment , tName varchar(200) not null , tCity varchar(200))";

            // create statement :

            Statement stmt = con.createStatement();

            stmt.executeUpdate(q);

            System.out.println("table created in database....");

            con.close();

        if(con.isClosed()) {
            System.out.println("Connection is closed\n");
        } else {
            System.out.println("Connection is created\n");
        }

        } catch(Exception e) {
            System.out.println("Cannot connect the database server");
            e.printStackTrace();
        }
    } 
}