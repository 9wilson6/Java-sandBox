import Helper.DBHandler;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    static private DBHandler dbHandler;
    static private Connection connection;
    static PreparedStatement preparedStatement;
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    dbHandler= new DBHandler();
    connection= dbHandler.getDbConnection();
//writeToDb();
//        readFromDb();
        updateDB("Gerald", "Magu", "Ngumo","5675db",12);
    }

    private static void updateDB(String firstname, String lastname, String username, String address, int age) throws SQLException {
        String query="UPDATE users set firstname=?, lastname=?, username=? WHERE firstname=?";
    preparedStatement= (PreparedStatement) connection.prepareStatement(query);
    preparedStatement.setString(1,firstname);
    preparedStatement.setString(2,lastname);
    preparedStatement.setString(3,username);
        preparedStatement.setString(4,"Ezekiel");
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    private static void readFromDb() throws SQLException {

        String query="SELECT * FROM users";
        preparedStatement= (PreparedStatement) connection.prepareStatement(query);
        ResultSet rs=preparedStatement.executeQuery();

        while (rs.next()){
            System.out.println("Names: "+ rs.getString("firstname") +" " + rs.getString("lastname")+" Age: "+
                    rs.getInt("age")+" Address: "+rs.getString("address"));
        }
    }

    private static void writeToDb() throws SQLException {
        String insert="INSERT INTO users(firstname,lastname,username,address, age)VALUES(?,?,?,?,?)";
        preparedStatement= (PreparedStatement) connection.prepareStatement(insert);
        preparedStatement.setString(1, "Haron");
        preparedStatement.setString(2, "Nganga");
        preparedStatement.setString(3, "ngash");
        preparedStatement.setString(4, "78954SB");
        preparedStatement.setInt(5, 46);
        preparedStatement.executeUpdate();

    }
}
