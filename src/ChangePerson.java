import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ChangePerson {

    public static void main(String[] args) throws SQLException {

        Scanner scan = new Scanner(System.in);

        System.out.println("Informe o código que deseja alterar: ");
        int code = scan.nextInt();

        String select = "SELECT code, name FROM persons WHERE code = ?";
        String update = "UPDATE persons SET name = ? WHERE code = ?";

        Connection connection = ConnectionFactory.getConncetion();
        PreparedStatement stmt = connection.prepareStatement(select);
        stmt.setInt(1, code);
        ResultSet result = stmt.executeQuery();

        if(result.next()) {
            Person p = new Person(result.getInt(1), result.getString(2));
            System.out.println("O nome atual é " + p.getName());
            scan.nextLine();

            System.out.println("Informe o novo nome: ");
            String newName = scan.nextLine();

            stmt.close();
            stmt = connection.prepareStatement(update);
            stmt.setString(1, newName);
            stmt.setInt(2, code);
            stmt.execute();
        } else {
            System.out.println("Pessoa não encontrada!");
        }
        connection.close();
        scan.close();
    }
}
