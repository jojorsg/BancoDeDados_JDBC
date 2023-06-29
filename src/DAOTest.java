public class DAOTest {

    public static void main(String[] args) {

        DAO dao = new DAO();
        String sql = "INSERT INTO persons (name) VALUES (?)";
        dao.include(sql, "Ana Lídia");
        dao.include(sql, "Renan Elias");
        dao.include(sql, "Bianca de Souza");
        dao.include(sql, "José Roberto");

        dao.close();
    }
}
