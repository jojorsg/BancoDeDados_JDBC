import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDataBase {

    public static void main(String[] args) throws SQLException {

        Connection conncetion = ConnectionFactory.getConncetion();

        Statement stmt = conncetion.createStatement();
        stmt.execute("CREATE DATABASE IF NOT EXISTS data_base");

        conncetion.close();
    }
}
