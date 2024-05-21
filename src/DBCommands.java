import Database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCommands {
    public static boolean verificarUsuario(String usuario, String senha) {
        try {
            Connection conexao = DBConnection.conectar();
            String consulta = "SELECT * FROM tbl_login WHERE usuario = ? AND senha = ?";
            PreparedStatement stmt = conexao.prepareStatement(consulta);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            boolean usuarioExiste = rs.next();

            rs.close();
            stmt.close();
            DBConnection.fecharConexao();

            return usuarioExiste;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean cadastrarUsuario(String usuario, String senha) {
        try {
            Connection conexao = DBConnection.conectar();
            String insercao = "INSERT INTO tbl_login (usuario, senha) VALUES (?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(insercao);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            int linhasAfetadas = stmt.executeUpdate();

            stmt.close();
            DBConnection.fecharConexao();

            // Se a inserção foi bem-sucedida e afetou pelo menos uma linha, retorna verdadeiro
            return linhasAfetadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }


}

