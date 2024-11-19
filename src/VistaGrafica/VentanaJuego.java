package VistaGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Dado;
import Modelo.Jugador;

import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class VentanaJuego extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private VistaGrafica vista;
	private JLabel lblNewLabel_1;
	private int player = 1;
	private JLabel pieza_roja;
	private JLabel pieza_azul;
	private JLabel pieza_verde;
	private JLabel pieza_amarilla;
	private JLabel dado;
	private JLabel notificaciones;
	private JLabel lblSoE;
	private JLabel notificaciones2;

	public void reproducirMusica(String nombreMusica) {
		try {
			;
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(nombreMusica).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.loop(Clip.LOOP_CONTINUOUSLY); // Música en bucle
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al cargar el archivo de música.");
		}
	}

    public void ReproducirSonido(String nombreSonido){
        try {
         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
         Clip clip = AudioSystem.getClip();
         clip.open(audioInputStream);
         clip.start();
        } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
          System.out.println("Error al reproducir el sonido.");
        }
      }


	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJuego frame = new VentanaJuego();
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
	public VentanaJuego(VistaGrafica vista) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./Img/icono.png"));
		setTitle("Serpientes y Escaleras");
		this.vista = vista;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 790);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);	
		
		JPanelBackground panel = new JPanelBackground();
		panel.setOpaque(false);
		panel.setBackground("./Img/tablero.jpg");
		panel.setBounds(0, 0, 750, 750);
		contentPane.add(panel);
		panel.setLayout(null); 
		
		
		/*JPanel panel = new JPanel();
		panel.setBounds(0, 0, 750, 750);
		contentPane.add(panel);
		panel.setLayout(null); */ 
		
		pieza_roja = new JLabel("");
		pieza_roja.setIcon(new ImageIcon("./Img/pieza_roja.png"));
		pieza_roja.setBounds(0, 675, 75, 75);
		panel.add(pieza_roja);
		pieza_roja.setVisible(false);
		
		
		pieza_azul = new JLabel("");
		pieza_azul.setIcon(new ImageIcon("./Img/pieza_azul.png"));
		pieza_azul.setBounds(0, 675, 75, 75);
		panel.add(pieza_azul);
		pieza_azul.setVisible(false);
		
		pieza_verde = new JLabel("");
		pieza_verde.setIcon(new ImageIcon("./Img/pieza_verde.png"));
		pieza_verde.setBounds(0, 675, 75, 75);
		panel.add(pieza_verde);
		pieza_verde.setVisible(false);
		
		pieza_amarilla = new JLabel("");
		pieza_amarilla.setIcon(new ImageIcon("./Img/pieza_amarilla.png"));
		pieza_amarilla.setBounds(0, 675, 75, 75);
		panel.add(pieza_amarilla);
		contentPane.setLayout(null);
		pieza_amarilla.setVisible(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GREEN.darker().darker());
		panel_1.setBounds(748, 0, 176, 750);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Jugador actual");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("MV Boli", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 96, 144, 23);
		panel_1.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("jugador");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("MV Boli", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 130, 86, 23);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("tirar dado");
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.ORANGE);
		btnNewButton.setFont(new Font("MV Boli", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReproducirSonido("./sound/dice.wav");
				notificaciones.setText("");
				notificaciones2.setText("");
				lblSoE.setText("");
				vista.jugarTurno();
			}
		});
		btnNewButton.setBounds(25, 528, 113, 90);
		panel_1.add(btnNewButton);
		
		dado = new JLabel("");
		dado.setIcon(new ImageIcon(".Img/cara 1.png"));
		dado.setBounds(32, 418, 99, 99);
		panel_1.add(dado);
		
		lblSoE = new JLabel("");
		lblSoE.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoE.setForeground(Color.ORANGE);
		lblSoE.setFont(new Font("Segoe Script", Font.PLAIN, 27));
		lblSoE.setBounds(5, 233, 171, 60);
		panel_1.add(lblSoE);
		
		notificaciones = new JLabel("");
		notificaciones.setHorizontalAlignment(SwingConstants.CENTER);
		notificaciones.setForeground(Color.ORANGE);
		notificaciones.setFont(new Font("MV Boli", Font.PLAIN, 17));
		notificaciones.setToolTipText("");
		notificaciones.setBounds(5, 354, 166, 35);
		panel_1.add(notificaciones);
		
		notificaciones2 = new JLabel("");
		notificaciones2.setToolTipText("");
		notificaciones2.setHorizontalAlignment(SwingConstants.CENTER);
		notificaciones2.setForeground(Color.ORANGE);
		notificaciones2.setFont(new Font("MV Boli", Font.PLAIN, 17));
		notificaciones2.setBounds(5, 379, 166, 35);
		panel_1.add(notificaciones2);

		reproducirMusica("./sound/musica.wav");
	}

	public void mostrarJugador(String name) {
		lblNewLabel_1.setText(name);
	}
	
	public void mostrarDado(int cara) {
		switch(cara) {
			case 1:
				dado.setIcon(new ImageIcon("./Img/cara 1.png"));
				break;
			case 2:
				dado.setIcon(new ImageIcon("./Img/cara 2.png"));
				break;
			case 3:
				dado.setIcon(new ImageIcon("./Img/cara 3.png"));
				break;
			case 4:
				dado.setIcon(new ImageIcon("./Img/cara 4.png"));
				break;
			case 5:
				dado.setIcon(new ImageIcon("./Img/cara 5.png"));
				break;
			case 6:	
				dado.setIcon(new ImageIcon("./Img/cara 6.png"));
				notificaciones.setText("Sacaste un 6 ");
				notificaciones2.setText("Tira denuevo!");
				ReproducirSonido("./sound/6face.wav");
				break;
		}
	}

	public void mostrarSerpiente() {
		lblSoE.setText("Serpiente");
		ReproducirSonido("./sound/snake.wav");
	}
	
	public void mostrarEscalera() {
		lblSoE.setText("Escalera");
		ReproducirSonido("./sound/stair.wav");
		
	}
	
	public void mostrarPieza(int nj) {
		JLabel pieza = elegirpieza(nj);
		pieza.setVisible(true);
	}
	
	public void cambioPosicion(int pos, int num) {
		JLabel pieza = elegirpieza(num);
		pieza.setVisible(true);
		pieza.setBounds(posx(pos), posy(pos), 80, 80);
		
	}

	private int posy(int pos) {
		return 675 - ((pos - 1) / 10) * 75;
	}

	private int posx(int pos) {
		int div = (pos - 1) % 10;  // Índice de la columna
		int fila = (pos - 1) / 10; // Índice de la fila
		return (fila % 2 == 0) ? div * 75 : 675 - (div * 75);
	}

	private JLabel elegirpieza(int numero) {
		JLabel pieza = null;
		switch(numero) {
		 case 1: pieza = pieza_roja; break;
		 case 2: pieza = pieza_azul; break;
		 case 3: pieza = pieza_verde; break;
		 case 4: pieza = pieza_amarilla; break;
		}
		return pieza;		
	}
	
	public void reiniciar() {
		ReproducirSonido("./sound/win.wav");
		pieza_roja.setBounds(0, 675, 75, 75);
		pieza_azul.setBounds(0, 675, 75, 75);
		pieza_amarilla.setBounds(0, 675, 75, 75);
		pieza_verde.setBounds(0, 675, 75, 75);
		pieza_roja.setVisible(false);
		pieza_azul.setVisible(false);
		pieza_amarilla.setVisible(false);
		pieza_verde.setVisible(false);
		lblSoE.setText("");
		notificaciones.setText("");
		notificaciones2.setText("");
		
	}
	
}
