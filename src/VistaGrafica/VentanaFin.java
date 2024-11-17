package VistaGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Jugador;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class VentanaFin extends JFrame {

	private JPanel contentPane;
	private VistaGrafica vista;
	private JLabel lblganador;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaFin frame = new VentanaFin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaFin(VistaGrafica vista) {
		setTitle("Serpientes y Escaleras");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./Img/icono.png"));
		this.vista = vista;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFinDelJuego = new JLabel("Fin del juego");
		lblFinDelJuego.setFont(new Font("MV Boli", Font.PLAIN, 30));
		lblFinDelJuego.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinDelJuego.setBounds(66, 11, 439, 77);
		contentPane.add(lblFinDelJuego);
		
		lblganador = new JLabel("");
		lblganador.setFont(new Font("MV Boli", Font.PLAIN, 30));
		lblganador.setHorizontalAlignment(SwingConstants.CENTER);
		lblganador.setBounds(10, 77, 551, 77);
		contentPane.add(lblganador);
		
		JButton btnJugarDenuevo = new JButton("otra vez!");
		btnJugarDenuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.mostrarMenuInicio();
			}
		});
		btnJugarDenuevo.setForeground(Color.BLUE);
		btnJugarDenuevo.setFont(new Font("MV Boli", Font.PLAIN, 15));
		btnJugarDenuevo.setBounds(147, 194, 115, 38);
		contentPane.add(btnJugarDenuevo);
		
		JButton btnSalir = new JButton("salir");
		btnSalir.setForeground(Color.BLUE);
		btnSalir.setFont(new Font("MV Boli", Font.PLAIN, 16));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(287, 194, 115, 38);
		contentPane.add(btnSalir);
		
		JLabel deadsnake = new JLabel("");
		deadsnake.setIcon(new ImageIcon("./Img/deadsnake.png"));
		deadsnake.setBounds(0, 11, 127, 207);
		contentPane.add(deadsnake);
		
		JLabel winner = new JLabel("");
		winner.setIcon(new ImageIcon("./Img/winner.png"));
		winner.setBounds(438, 11, 143, 151);
		contentPane.add(winner);
	}

	public void MostrarGanador(Jugador jugador) {
		lblganador.setText(jugador.getNombre() + " a ganado!");
	}
}
