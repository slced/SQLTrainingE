import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenPratica {
    public ScreenPratica(){

        // Criação da tela Main
        JFrame frameMain = new JFrame();
        frameMain.setSize(700, 500);
        frameMain.setLocationRelativeTo(null);
        frameMain.setResizable(false);
        frameMain.setTitle("Tela de Praticar");
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Caminho da imagem de fundo
        String backgroundImagePath = "C:\\Users\\EDSON JUNIOR\\IdeaProjects\\SQLTrainingE\\src\\img\\backgroundlogin.png";

        // Criação do painel principal com a imagem de fundo
        BackgroundPanel panelMain = new BackgroundPanel(backgroundImagePath);
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));

        // Restante do código continua igual
        panelMain.add(Box.createVerticalStrut(10)); // Espaçamento de 10px do que vier abaixo.
        //---------------------------------------------------

        // Criação da imagem de logo.
        String imagePatch = "C:\\Users\\EDSON JUNIOR\\IdeaProjects\\SQLTrainingE\\src\\img\\SQLTRANINGELOGO.png";
        ImageIcon LoginIcon = new ImageIcon(imagePatch);
        int width = 200;
        int height = 40;
        Image scaledImg = LoginIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        JLabel label = new JLabel(scaledIcon);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelMain.add(label);
        //---------------------------------------------------

        panelMain.add(Box.createVerticalStrut(10));
        //---------------------------------------------------

        // Criação da caixa de texto para entrada do comando SQL
        JTextField comandoField = new JTextField();
        comandoField.setToolTipText("Digite o comando SQL que deseja executar");
        comandoField.setAlignmentX(Component.CENTER_ALIGNMENT);
        comandoField.setMaximumSize(new Dimension(300, comandoField.getPreferredSize().height));
        panelMain.add(comandoField);

        panelMain.add(Box.createVerticalStrut(10));

        // Criação do JLabel para exibir o resultado do comando SQL
        JLabel resultadoLabel = new JLabel("Resultado da Consulta Aqui");
        resultadoLabel.setForeground(Color.WHITE);
        resultadoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultadoLabel.setFont(new Font("Candara", Font.BOLD, 14));
        resultadoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panelMain.add(resultadoLabel, BorderLayout.CENTER);

        //---------------------------------------------------

        panelMain.add(Box.createVerticalStrut(10));
        //---------------------------------------------------

        JButton btnbd = new JButton();
        btnbd.setText("INFORMAÇÕES");
        btnbd.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnbd.setMaximumSize(new Dimension(150, btnbd.getPreferredSize().height));
        panelMain.add(btnbd, BorderLayout.CENTER);

        //

        JButton btnback = new JButton();
        btnback.setText("VOLTAR");
        btnback.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnback.setMaximumSize(new Dimension(150, btnbd.getPreferredSize().height));
        panelMain.add(btnback, BorderLayout.CENTER);

        //

        btnbd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ScreenInfo();
            }
        });

        btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
                frame.dispose();
                new ScreenFirst();
            }
        });

        comandoField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String comando = comandoField.getText();

                // Executa o comando SQL e atualiza o JLabel com o resultado
                String resultado = DBCommands.executarComandoSQL(comando);
                resultadoLabel.setText("<html>" + resultado + "</html>");
            }
        });

        frameMain.add(panelMain);
        frameMain.setVisible(true);
    }
}
