package Controlador;

import Modelo.IJuego;
import Modelo.Juego;
import Modelo.Updates;
import Persistencia.Ranking;
import ar.edu.unlu.rmimvc.cliente.IControladorRemoto;
import ar.edu.unlu.rmimvc.observer.IObservableRemoto;


import java.rmi.RemoteException;

import static Persistencia.Serializador.serializar;

public class Controlador implements IControladorRemoto {
	private IJuego game = Juego.getInstance();
	private Ivista vista;
	private int idJugador;
	private Ranking ranking = Ranking.cargarRanking();
	
	//constructor
	public Controlador (Ivista vista) {
		this.vista = vista;

		//version agregarObservador sin RMI
		/*
		try {
            this.game.agregarObservador(this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

         */
        vista.setControlador(this);
		vista.mostrarMenuInicio();
	}
	

	//version de actualizar sin RMI
	/*
	//@Override
	public void actualizar(Updates update) {
		try {
		switch(update) {
			case CAMBIO_JUGADOR:
				vista.mostrarJugador(game.getJugadorActual().getNombre());
				break;
			case CAMBIO_DADO:
				vista.mostrarDado(game.getDado().getCara());
				break;
			case CAMBIO_POSICION:
				vista.cambioPosicion(game.getJugadorActual().getPosicion(),
						             game.getJugadorActual().getNumero());
				break;
			case ESCALERA:
				vista.mostrarEscalera();
				break;
			case SERPIENTE:
				vista.mostrarSerpiente();
				break;
			case FIN_DEL_JUEGO:
				vista.mostrarMenuFin(game.getJugadorActual().getNombre());
				break;
			case COMIENZO_DEL_JUEGO:
				vista.mostrarMenuJuego();
				break;
			default:
				break;
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 */
	
	public void agregarJugador(String nombre) {
        try {
			if(game.getJugadores().size() < 4) {
				idJugador = game.getNumero();
				game.agregarJugador(nombre);
			}
			else{
				vista.mostrarMaximoJugadores();
			}
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
	
	
	public void comenzar() {
        try {
            game.comenzar();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
	
	public void jugarTurno() {
        try {
            game.jugarTurno();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

	//persistencia
	public void actualizarRanking() throws RemoteException {
		ranking.actualizarRanking(game.getJugadorActual().getNombre(), game.getJugadorActual().getMovimientos());
		serializar("ranking.ser", ranking);
	}

	public void mostrarRanking() {
		vista.mostrarRanking(ranking.obtenerRanking());
	}


	public int getidJugador() {
		return this.idJugador;
	}

	@Override
	public void actualizar(IObservableRemoto observable, Object update) throws RemoteException {
		if (update instanceof Updates) {
			try {
				switch((Updates) update) {
					case MOSTRAR_JUGADOR:
						vista.mostrarJugadores(game.getJugadores());
						break;
					case CAMBIO_JUGADOR:
						vista.mostrarJugador(game.getJugadorActual().getNombre());
						if (this.idJugador == game.getJugadorActual().getNumero()){
							vista.habilitarJugador();
						}
						break;
					case CAMBIO_DADO:
						vista.mostrarDado(game.getDado().getCara());
						break;
					case CAMBIO_POSICION:
						vista.cambioPosicion(game.getJugadorActual().getPosicion(),
								game.getJugadorActual().getNumero());
						break;
					case ESCALERA:
						vista.mostrarEscalera();
						break;
					case SERPIENTE:
						vista.mostrarSerpiente();
						break;
					case SACO_6:
						if (this.idJugador == game.getJugadorActual().getNumero()){
							vista.habilitarJugador();
							vista.mostrar6();
						}
						break;
					case FIN_DEL_JUEGO:
						vista.mostrarMenuFin(game.getJugadorActual().getNombre());
						actualizarRanking();
						break;
					case COMIENZO_DEL_JUEGO:
						vista.mostrarMenuJuego();
						break;
					default:
						break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public <T extends IObservableRemoto> void setModeloRemoto(T modeloRemoto) throws RemoteException {
		this.game = (IJuego) modeloRemoto;
	}
}
