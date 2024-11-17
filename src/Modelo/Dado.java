package Modelo;

import java.util.Random;

public class Dado {
	
	private int cara;
	
	public Dado() {
		this.cara = 1;
	}

	

	public int getCara() {
		return cara;
	}

	public void tirardado() {
		Random r = new Random();
		cara = 1 + r.nextInt(6);
	}
}
