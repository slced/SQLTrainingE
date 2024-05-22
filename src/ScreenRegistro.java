import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenRegistro {

    public ScreenRegistro() {

        //Criação da tela Main
        JFrame frameMain = new JFrame();
        frameMain.setSize(300, 300);
        frameMain.setLocationRelativeTo(null);
        frameMain.setResizable(false);
        frameMain.setTitle("Tela de Registro");
        //---------------------------------------------------

        // Caminho da imagem de fundo
        String backgroundImagePath = "C:\\Users\\EDSON JUNIOR\\IdeaProjects\\SQLTrainingE\\src\\img\\backgroundlogin.png";

        //Criação do Layout principal da página
        BackgroundPanel panelMain = new BackgroundPanel(backgroundImagePath);
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        //---------------------------------------------------

        panelMain.add(Box.createVerticalStrut(10)); //Espaçamento de 10px do que vier abaixo.

        //---------------------------------------------------



        //Criação da imagem na tela de registro.

        String imagePatch = "C:\\Users\\EDSON JUNIOR\\IdeaProjects\\SQLTrainingE\\src\\img\\logoLogin.png";
        ImageIcon RegistroIcon = new ImageIcon(imagePatch);
        int width = 40;
        int height = 40;
        Image scaledImg = RegistroIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        JLabel label = new JLabel(scaledIcon);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelMain.add(label);

        //---------------------------------------------------

        panelMain.add(Box.createVerticalStrut(10));

        //---------------------------------------------------

        //Criação do texto "Usuário"

        JLabel usuario = new JLabel();
        usuario.setText("Usuário");
        usuario.setForeground(Color.WHITE);
        usuario.setAlignmentX(Component.CENTER_ALIGNMENT);
        usuario.setFont(new Font("Candara", Font.BOLD, 20));
        panelMain.add(usuario);

        //---------------------------------------------------

        panelMain.add(Box.createVerticalStrut(10));

        //---------------------------------------------------

        //Criação da caixa de texto do USUÁRIO

        JTextField usuarioField = new JTextField();
        usuarioField.setAlignmentX(Component.CENTER_ALIGNMENT);
        usuarioField.setMaximumSize(new Dimension(200, usuarioField.getPreferredSize().height));
        panelMain.add(usuarioField);

        //---------------------------------------------------

        panelMain.add(Box.createVerticalStrut(10));

        //---------------------------------------------------

        //Criação do texto "Senha"

        JLabel senha = new JLabel();
        senha.setText("Senha");
        senha.setForeground(Color.WHITE);
        senha.setAlignmentX(Component.CENTER_ALIGNMENT);
        senha.setFont(new Font("Candara", Font.BOLD, 20));
        panelMain.add(senha);

        //---------------------------------------------------

        panelMain.add(Box.createVerticalStrut(10));

        //---------------------------------------------------

        //Criação da caixa de texto do SENHA

        JPasswordField senhaField = new JPasswordField();
        senhaField.setAlignmentX(Component.CENTER_ALIGNMENT);
        senhaField.setMaximumSize(new Dimension(200, usuarioField.getPreferredSize().height));
        panelMain.add(senhaField);
        //---------------------------------------------------

        panelMain.add(Box.createVerticalStrut(10));

        //---------------------------------------------------
        //Criação do botão "LOGAR"

        JButton buttonRegistro = new JButton();
        buttonRegistro.setText("REGISTRAR");
        buttonRegistro.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonRegistro.setMaximumSize(new Dimension(200, buttonRegistro.getPreferredSize().height));
        panelMain.add(buttonRegistro);
        //---------------------------------------------------

        panelMain.add(Box.createVerticalStrut(10));

        //---------------------------------------------------

        //Criação do botão "VOLTAR"

        JButton buttonBack = new JButton();
        buttonBack.setText("VOLTAR");
        buttonBack.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonBack.setMaximumSize(new Dimension(200, buttonRegistro.getPreferredSize().height));
        panelMain.add(buttonBack);
        //---------------------------------------------------

        panelMain.add(Box.createVerticalStrut(10));

        //---------------------------------------------------

        //AÇÃO BOTÃO REGISTRAR

        buttonRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioField.getText();
                String senha  = senhaField.getText();

                boolean sucesso = DBCommands.cadastrarUsuario(usuario, senha);

                if (sucesso){
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao cadastrar usuário!");
                }
            }
        });

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
                frame.dispose();
                new ScreenLogin();
            }
        });

        frameMain.add(panelMain);
        frameMain.setVisible(true);
    }
}