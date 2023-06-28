import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NewPerson {

    public static void main(String[] args) throws SQLException {

        Scanner scan = new Scanner(System.in);
        System.out.println("Informe o nome: ");
        String name = scan.nextLine();

        Connection connection = ConnectionFactory.getConncetion();

        String sql = "INSERT INTO persons (name) VALUES (?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, name);

        stmt.execute();

        stmt.close();
        scan.close();
    }
}
