package VistaGrafica;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;

public class VentanaInicio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private VistaGrafica vista;
	private JButton boton2;
	private JLabel labeljugador;
	private int nj = 1;
	private JLabel lblmaximo;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
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
		
		JButton boton1 = new JButton("Agregar jugador");
		boton1.setForeground(Color.BLUE);
		boton1.setFont(new Font("MV Boli", Font.PLAIN, 14));
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.agregarJugador(textField.getText());
				labeljugador.setText(textField.getText() + " agregado");
				vista.mostrarPieza(nj);
				textField.setText("");
				nj++;
				if (nj > 4) {
					boton1.setEnabled(false);
					lblmaximo.setText("Maximo de jugadores");
				}
				if(nj > 2)
					boton2.setEnabled(true);
			}
		});
		boton1.setBounds(26, 146, 151, 38);
		contentPane.add(boton1);
		
		JLabel lblNewLabel = new JLabel("Nombre jugador:");
		lblNewLabel.setFont(new Font("MV Boli", Font.PLAIN, 14));
		lblNewLabel.setBounds(26, 80, 118, 23);
		contentPane.add(lblNewLabel);
		
		boton2 = new JButton("Iniciar juego");
		boton2.setForeground(Color.BLUE);
		boton2.setFont(new Font("MV Boli", Font.PLAIN, 14));
		boton2.setEnabled(false);
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.comenzar();
				labeljugador.setText("");
				lblmaximo.setText("");
				nj = 1;
				boton2.setEnabled(false);
			}
		});
		boton2.setBounds(26, 281, 151, 38);
		contentPane.add(boton2);
		
		
		
		textField = new JTextField();
		textField.setFont(new Font("MV Boli", Font.PLAIN, 14));
		textField.setBounds(26, 105, 151, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		labeljugador = new JLabel("");
		labeljugador.setFont(new Font("MV Boli", Font.PLAIN, 14));
		labeljugador.setBounds(26, 195, 151, 23);
		contentPane.add(labeljugador);
		
		lblmaximo = new JLabel("");
		lblmaximo.setFont(new Font("MV Boli", Font.PLAIN, 14));
		lblmaximo.setBounds(26, 218, 151, 23);
		contentPane.add(lblmaximo);
	}
}
