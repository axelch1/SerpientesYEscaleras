package VistaGrafica;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRanking extends JFrame {

    private JPanel contentPane;
    private VistaGrafica vista;

    private JButton botonComenzar;

    private JLabel lblRanking;

    public VentanaRanking(VistaGrafica vista) {
        this.vista = vista;

        setIconImage(Toolkit.getDefaultToolkit().getImage("./Img/icono.png"));
        setTitle("Serpientes y Escaleras");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 389);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("./Img/Ranking.png"));
        label.setBounds(10, 0, 290, 350);
        contentPane.add(label);



        lblRanking = new JLabel("");
        lblRanking.setFont(new Font("MV Boli", Font.PLAIN, 18));
        lblRanking.setBounds(26, 110, 200, 200);
        lblRanking.setVerticalAlignment(SwingConstants.TOP); // Alineación vertical
        lblRanking.setHorizontalAlignment(SwingConstants.LEFT); // Alineación horizontal
        contentPane.add(lblRanking);

        botonComenzar = new JButton("Volver");
        botonComenzar.setForeground(Color.BLUE);
        botonComenzar.setFont(new Font("MV Boli", Font.PLAIN, 14));
        botonComenzar.setEnabled(true);
        botonComenzar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vista.volverMenuInicio();

            }
        });
        botonComenzar.setBounds(26, 281, 151, 38);
        contentPane.add(botonComenzar);
    }


    public void setRanking(String ranking) {
        lblRanking.setText("<html>" + ranking.replace("\n", "<br>") + "</html>");
    }
}

