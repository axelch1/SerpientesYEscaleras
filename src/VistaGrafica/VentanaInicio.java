package VistaGrafica;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class VentanaInicio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private VistaGrafica vista;
	private JButton botonAgregarse;
	private JButton botonComenzar;
	private JButton botonRanking;
	private JLabel labeljugador;
	private JLabel lblmaximo;

	public VentanaInicio(VistaGrafica vista) {
		this.vista = vista;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("./Img/icono.png"));
		setTitle("Serpientes y Escaleras");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("./Img/tituloSyE.png"));
		label.setBounds(187, 0, 238, 350);
		contentPane.add(label);
		
		botonAgregarse = new JButton("Agregarse");
		botonAgregarse.setForeground(Color.BLUE);
		botonAgregarse.setFont(new Font("MV Boli", Font.PLAIN, 14));
		botonAgregarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.agregarJugador(textField.getText());
				//labeljugador.setText(textField.getText() + " agregado");
				//vista.mostrarPieza(nj);
				//vista.mostrarPieza();
				textField.setText("");
				botonAgregarse.setEnabled(false);

				/* comprobacion de jugadores antigua
				nj++;
				if (nj > 4) {
					boton1.setEnabled(false);
					lblmaximo.setText("Maximo de jugadores");
				}
				if(nj > 2)
					boton2.setEnabled(true);

				 */
			}
		});
		botonAgregarse.setBounds(26, 115, 151, 38);
		contentPane.add(botonAgregarse);
		
		JLabel lblNewLabel = new JLabel("Nombre jugador:");
		lblNewLabel.setFont(new Font("MV Boli", Font.PLAIN, 14));
		lblNewLabel.setBounds(26, 50, 118, 23);
		contentPane.add(lblNewLabel);
		
		botonComenzar = new JButton("Iniciar juego");
		botonComenzar.setForeground(Color.BLUE);
		botonComenzar.setFont(new Font("MV Boli", Font.PLAIN, 14));
		botonComenzar.setEnabled(false);
		botonComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.comenzar();
				labeljugador.setText("");
				lblmaximo.setText("");
				//nj = 1;
			}
		});
		botonComenzar.setBounds(26, 281, 151, 38);
		contentPane.add(botonComenzar);

		botonRanking = new JButton("Ranking");
		botonRanking.setForeground(Color.BLUE);
		botonRanking.setFont(new Font("MV Boli", Font.PLAIN, 14));
		botonRanking.setEnabled(true);
		botonRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.getRanking();
			}
		});
		botonRanking.setBounds(26, 5, 151, 38);
		contentPane.add(botonRanking);
		
		
		
		textField = new JTextField();
		textField.setFont(new Font("MV Boli", Font.PLAIN, 14));
		textField.setBounds(26, 75, 151, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		labeljugador = new JLabel("");
		labeljugador.setFont(new Font("MV Boli", Font.PLAIN, 14));
		labeljugador.setBounds(26, 165, 151, 92);
		labeljugador.setVerticalAlignment(SwingConstants.TOP); // Alineación vertical
		labeljugador.setHorizontalAlignment(SwingConstants.LEFT); // Alineación horizontal
		contentPane.add(labeljugador);
		
		lblmaximo = new JLabel("");
		lblmaximo.setFont(new Font("MV Boli", Font.PLAIN, 14));
		lblmaximo.setBounds(26, 218, 151, 23);
		contentPane.add(lblmaximo);
	}

	public void mostrarJugadores(ArrayList<String> listaJugadores) {
		StringBuilder jugadoresHTML = new StringBuilder("<html>");

		for (String jugador : listaJugadores) {
			jugadoresHTML.append(jugador).append("<br>");
		}

		jugadoresHTML.append("</html>");

		labeljugador.setText(jugadoresHTML.toString());

		if (listaJugadores.size() >= 2) {
			botonComenzar.setEnabled(true);

		}
	}

	public void mostrarMaximoJugadores() {
		lblmaximo.setText("Maximo de jugadores");
	}

	public void reiniciarBotones() {
		botonComenzar.setEnabled(false);
		botonAgregarse.setEnabled(true);
	}
}
