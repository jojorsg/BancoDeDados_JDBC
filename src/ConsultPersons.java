import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultPersons {

    public static void main(String[] args) throws SQLException {

        Scanner scan = new Scanner(System.in);

        Connection connection = ConnectionFactory.getConncetion();
        String sql = "SELECT * FROM persons WHERE name LIKE ?";

        System.out.println("Informe o valor que deseja consultar: ");
        String valor = scan.nextLine();

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, "%" + valor + "%");
        ResultSet result = stmt.executeQuery();

        List<Person> people = new ArrayList<>();
        while(result.next()) {
            int code = result.getInt("code");
            String name = result.getString("name");
            people.add(new Person(code, name));
        }

        for(Person p: people) {
            System.out.println(p.getCode() + " --> " + p.getName());
        }

        stmt.close();
        connection.close();
        scan.close();
    }
}
