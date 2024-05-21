import javax.swing.*;
import java.awt.*;

public class ScreenFirst {
    public ScreenFirst(){

        //Criação da tela Main
        JFrame frameMain = new JFrame();
        frameMain.setSize(300,300);
        frameMain.setLocationRelativeTo(null);
        frameMain.setResizable(false);
        frameMain.setTitle("Início");
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //---------------------------------------------------

        //Criação do Layout principal da página
        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        //---------------------------------------------------

        panelMain.add(Box.createVerticalStrut(10)); //Espaçamento de 10px do que vier abaixo.

        //---------------------------------------------------

        //Criação do texto "Escolha uma opção
        JLabel senha = new JLabel();
        senha.setText("Escolha uma opção");
        senha.setAlignmentX(Component.CENTER_ALIGNMENT);
        senha.setFont(new Font("Candara", Font.BOLD, 20 ));
        panelMain.add(senha);

        //---------------------------------------------------
        panelMain.add(Box.createVerticalStrut(10));

        //---------------------------------------------------
        //Criação do botão "Estudar"

        JButton buttonEstudy = new JButton();
        buttonEstudy.setText("ESTUDARr");
        buttonEstudy.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonEstudy.setMaximumSize(new Dimension(200, buttonEstudy.getPreferredSize().height));
        panelMain.add(buttonEstudy);
        //---------------------------------------------------

        panelMain.add(Box.createVerticalStrut(10));

        //---------------------------------------------------
        //Criação do botão "Praticar"

        JButton buttonPratic = new JButton();
        buttonPratic.setText("PRATICAR");
        buttonPratic.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPratic.setMaximumSize(new Dimension(200, buttonPratic.getPreferredSize().height));
        panelMain.add(buttonPratic);
        //---------------------------------------------------

        frameMain.add(panelMain);
        frameMain.setVisible(true);
    }
}
