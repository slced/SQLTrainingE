

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenLogin {

    public ScreenLogin() {

            //Criação da tela Main
        JFrame frameMain = new JFrame();
        frameMain.setSize(300,300);
        frameMain.setLocationRelativeTo(null);
        frameMain.setResizable(false);
        frameMain.setTitle("Tela de Login");
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //---------------------------------------------------

            //Criação do Layout principal da página
        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
             //---------------------------------------------------

        panelMain.add(Box.createVerticalStrut(10)); //Espaçamento de 10px do que vier abaixo.

            //---------------------------------------------------

            //Criação da imagem na tela de Login.

        String imagePatch = "C:\\Users\\EDSON JUNIOR\\IdeaProjects\\SQLTrainingE\\src\\img\\logoLogin.png";
        ImageIcon LoginIcon = new ImageIcon(imagePatch);
            int width = 40;
            int height = 40;
        Image scaledImg = LoginIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
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
        usuario.setAlignmentX(Component.CENTER_ALIGNMENT);
        usuario.setFont(new Font("Candara", Font.BOLD, 20 ));
        panelMain.add(usuario);

        //---------------------------------------------------

        panelMain.add(Box.createVerticalStrut(10));

        //---------------------------------------------------

        //Criação da caixa de texto do USUÁRIO

        JTextField usuarioField = new JTextField();
        usuarioField.setToolTipText("Informe o seu usuário!");
        usuarioField.setAlignmentX(Component.CENTER_ALIGNMENT);
        usuarioField.setMaximumSize(new Dimension(200, usuarioField.getPreferredSize().height));
        panelMain.add(usuarioField);

        //---------------------------------------------------

        panelMain.add(Box.createVerticalStrut(10));

        //---------------------------------------------------

        //Criação do texto "Senha"

        JLabel senha = new JLabel();
        senha.setText("Senha");
        senha.setAlignmentX(Component.CENTER_ALIGNMENT);
        senha.setFont(new Font("Candara", Font.BOLD, 20 ));
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

        JButton buttonLogin = new JButton();
        buttonLogin.setText("LOGAR");
        buttonLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonLogin.setMaximumSize(new Dimension(200, buttonLogin.getPreferredSize().height));
        panelMain.add(buttonLogin);
        //---------------------------------------------------

        panelMain.add(Box.createVerticalStrut(10));

        //---------------------------------------------------
        //Criação do botão "CADASTRAR"

        JButton buttonCadastro = new JButton();
        buttonCadastro.setText("CADASTRAR");
        buttonCadastro.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonCadastro.setMaximumSize(new Dimension(200, buttonCadastro.getPreferredSize().height));
        panelMain.add(buttonCadastro);
        //---------------------------------------------------

        panelMain.add(Box.createVerticalStrut(10));

        //---------------------------------------------------

        //AÇÃO DO BOTÃO LOGAR

        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioField.getText();
                String senha = senhaField.getText();

            boolean usuarioExiste = DBCommands.verificarUsuario(usuario, senha);

                // Exibir mensagem de acordo com o resultado da verificação
                if (usuarioExiste) {
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
                    frame.dispose();
                    new ScreenFirst();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário não encontrado");                }
            }
        });

        buttonCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
                frame.dispose();
                new ScreenRegistro();
            }
        });


//Comando para fazer a página fechar logo após algum comando
        //JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
       // frame.dispose();














        frameMain.add(panelMain);
        frameMain.setVisible(true);
    }
}
