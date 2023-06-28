import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    public static Connection getConncetion() {
        try {
            Properties prop = getProperties();
            final String url = prop.getProperty("data_base.url");
            final String user = prop.getProperty("data_base.user");
            final String senha = prop.getProperty("data_base.senha");

            return DriverManager.getConnection(url, user, senha);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Properties getProperties() throws IOException {
        Properties prop = new Properties();
        String path = "/connection.properties";
        prop.load(ConnectionFactory.class.getResourceAsStream(path));
        return prop;
    }
}
