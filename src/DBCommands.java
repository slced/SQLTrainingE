import Database.DBConnection;
import Database.DBConnectionEmpdbste;

import java.sql.*;

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

    public static String executarComandoSQL(String comando) {
        try {
            Connection conexao = DBConnectionEmpdbste.conectar();
            PreparedStatement stmt = conexao.prepareStatement(comando);
            boolean resultado = stmt.execute();

            // Se o comando for uma consulta SELECT
            if (resultado) {
                ResultSet rs = stmt.getResultSet();
                ResultSetMetaData metaData = rs.getMetaData();
                int numColunas = metaData.getColumnCount();

                StringBuilder resultadoString = new StringBuilder();
                resultadoString.append("<html><table border='1'><tr>");

                // Adicionando os nomes das colunas à primeira linha da tabela
                for (int i = 1; i <= numColunas; i++) {
                    resultadoString.append("<th>").append(metaData.getColumnName(i)).append("</th>");
                }
                resultadoString.append("</tr>");

                // Adicionando os valores das colunas às linhas da tabela
                while (rs.next()) {
                    resultadoString.append("<tr>");
                    for (int i = 1; i <= numColunas; i++) {
                        resultadoString.append("<td>").append(rs.getString(i)).append("</td>");
                    }
                    resultadoString.append("</tr>");
                }

                resultadoString.append("</table></html>");

                rs.close();
                stmt.close();
                DBConnectionEmpdbste.fecharConexao();
                return resultadoString.toString();
            } else {
                stmt.close();
                DBConnectionEmpdbste.fecharConexao();
                return "Comando executado com sucesso.";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "Erro ao executar o comando, tente novamente! ";
        }
    }


}

