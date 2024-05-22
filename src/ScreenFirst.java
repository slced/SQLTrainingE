import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        //Background da tela
        String backgroundImagePath = "C:\\Users\\EDSON JUNIOR\\IdeaProjects\\SQLTrainingE\\src\\img\\backgroundfirst.jpg";
        //-------------------------------------

        //Criação do Layout principal da página
        BackgroundPanel panelMain = new BackgroundPanel(backgroundImagePath);
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        //---------------------------------------------------

        panelMain.add(Box.createVerticalStrut(10)); //Espaçamento de 10px do que vier abaixo.

        //---------------------------------------------------

        //Criação do texto "Escolha uma opção
        JLabel textopcao = new JLabel();
        textopcao.setText("Escolha uma opção");
        textopcao.setForeground(Color.WHITE);
        textopcao.setAlignmentX(Component.CENTER_ALIGNMENT);
        textopcao.setFont(new Font("Candara", Font.BOLD, 20 ));
        panelMain.add(textopcao);

        //---------------------------------------------------
        panelMain.add(Box.createVerticalStrut(40));

        //---------------------------------------------------
        //Criação do botão "Estudar"

        JButton buttonEstudy = new JButton();
        buttonEstudy.setText("ESTUDAR");
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
        //---------------------------------------------------

        panelMain.add(Box.createVerticalStrut(50)); //Espaçamento de 10px do que vier abaixo.

        //---------------------------------------------------
        // Criação da imagem logo.
        String imagePatch = "C:\\Users\\EDSON JUNIOR\\IdeaProjects\\SQLTrainingE\\src\\img\\sqlte.png";
        ImageIcon LoginIcon = new ImageIcon(imagePatch);
        int width = 200;
        int height = 60;
        Image scaledImg = LoginIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        JLabel label = new JLabel(scaledIcon);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelMain.add(label);
        //---------------------------------------------------
        //AÇÃO BOTÃO PRATICAR

        buttonPratic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
                frame.dispose();
                new ScreenPratica();
            }
        });


        //-------------------------------------------------

        frameMain.add(panelMain);
        frameMain.setVisible(true);
    }
}
