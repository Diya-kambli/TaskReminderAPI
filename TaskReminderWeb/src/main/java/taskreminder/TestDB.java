package taskreminder;

import java.sql.Connection;

public class TestDB {

    public static void main(String[] args) {

        Connection connection = DBConnection.getConnection();

        if (connection != null) {
            System.out.println("MySQL Connection Successful!");
        } else {
            System.out.println("MySQL Connection Failed!");
        }
    }
}