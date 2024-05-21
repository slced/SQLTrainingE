package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/sqltraininge";
    private static final String USUARIO = "administrator";
    private static final String SENHA = "Qp01@l10";
    private static Connection conexao;

    public static Connection conectar() throws SQLException {
        conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        return conexao;
    }

    public static void fecharConexao() throws SQLException {
        if (conexao != null) {
            conexao.close();
        }
    }
}
