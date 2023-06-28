import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletePerson {

    public static void main(String[] args) throws SQLException {

        Scanner scan = new Scanner(System.in);
        System.out.println("Informe o código da pessoa que deseja deletar: ");
        int code = scan.nextInt();

        Connection connection = ConnectionFactory.getConncetion();
        String sql = "DELETE FROM persons WHERE code = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, code);

        if(stmt.executeUpdate() > 0) {
            return;
        } else {
            System.out.println("A pessoa não existe e/ou não foi excluída!");
        }

        scan.close();
        connection.close();
    }
}
