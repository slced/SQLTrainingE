import Database.DBConnectionEmpdbste;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ScreenInfo {

    public ScreenInfo() {
        JFrame frameMain = new JFrame();
        frameMain.setResizable(true);
        frameMain.setLocationRelativeTo(null);
        frameMain.setSize(800, 600);
        frameMain.setTitle("Informações");

        // Painel principal com imagem de fundo
        String backgroundImagePatch = "C:\\Users\\EDSON JUNIOR\\IdeaProjects\\SQLTrainingE\\src\\img\\backgroundlogin.png";
        BackgroundPanel panelMain = new BackgroundPanel(backgroundImagePatch);
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));

        // Título da tabela
        JLabel titleLabel = new JLabel("Tabela de Funcionários");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelMain.add(titleLabel);

        // Tabela para exibir os dados dos funcionários
        JTable funcionariosTable = new JTable();
        JScrollPane funcionariosScrollPane = new JScrollPane(funcionariosTable);
        panelMain.add(funcionariosScrollPane);

        // Executar consulta para funcionarios
        executeQuery("SELECT * FROM funcionarios", funcionariosTable);

        // Adiciona espaço entre as tabelas
        panelMain.add(Box.createRigidArea(new Dimension(0, 20)));

        // Título da tabela
        JLabel departamentosLabel = new JLabel("Tabela de Departamentos");
        departamentosLabel.setFont(new Font("Arial", Font.BOLD, 20));
        departamentosLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelMain.add(departamentosLabel);

        // Tabela para exibir os dados dos departamentos
        JTable departamentosTable = new JTable();
        JScrollPane departamentosScrollPane = new JScrollPane(departamentosTable);
        panelMain.add(departamentosScrollPane);

        // Executar consulta para departamentos
        executeQuery("SELECT * FROM departamentos", departamentosTable);

        // Adiciona espaço entre as tabelas
        panelMain.add(Box.createRigidArea(new Dimension(0, 20)));

        // Título da tabela
        JLabel atribuicoesLabel = new JLabel("Tabela de Atribuições");
        atribuicoesLabel.setFont(new Font("Arial", Font.BOLD, 20));
        atribuicoesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelMain.add(atribuicoesLabel);

        // Tabela para exibir os dados das atribuições
        JTable atribuicoesTable = new JTable();
        JScrollPane atribuicoesScrollPane = new JScrollPane(atribuicoesTable);
        panelMain.add(atribuicoesScrollPane);

        // Executar consulta para atribuições
        executeQuery("SELECT * FROM atribuicoes", atribuicoesTable);

        // Adiciona espaço entre as tabelas
        panelMain.add(Box.createRigidArea(new Dimension(0, 20)));

        // Título da tabela
        JLabel projetosLabel = new JLabel("Tabela de Projetos");
        projetosLabel.setFont(new Font("Arial", Font.BOLD, 20));
        projetosLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelMain.add(projetosLabel);

        // Tabela para exibir os dados dos projetos
        JTable projetosTable = new JTable();
        JScrollPane projetosScrollPane = new JScrollPane(projetosTable);
        panelMain.add(projetosScrollPane);

        // Executar consulta para projetos
        executeQuery("SELECT * FROM projetos", projetosTable);

        frameMain.add(panelMain);
        frameMain.setVisible(true);
    }

    // Método para executar uma consulta e preencher uma tabela
    private void executeQuery(String query, JTable table) {
        try {
            Connection connection = DBConnectionEmpdbste.conectar();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            table.setModel(buildTableModel(resultSet));
            DBConnectionEmpdbste.fecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados.");
        }
    }

    // Método para converter um ResultSet em um DefaultTableModel
    private DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        // Nomes das colunas
        String[] columnNames = new String[columnCount];
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            columnNames[columnIndex - 1] = metaData.getColumnLabel(columnIndex);
        }

        // Dados da tabela
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        while (resultSet.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                row[i - 1] = resultSet.getObject(i);
            }
            tableModel.addRow(row);
        }
        return tableModel;
    }

    public static void main(String[] args) {
        new ScreenInfo();
    }
}
