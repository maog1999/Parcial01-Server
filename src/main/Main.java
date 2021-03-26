package main;

import java.util.LinkedList;

import processing.core.PApplet;

public class Main extends PApplet {

	// Variables Globales
	String color, texto, confirmacion;
	int posX, posY;
	boolean vista = false;

	private TCPConnection conexion;
	private LinkedList<Recordatorio> recorderis;

	public static void main(String[] args) {
		PApplet.main("main.Main");

	}

	public void settings() {
		size(1000, 500);

	}

	public void setup() {

		recorderis = new LinkedList<Recordatorio>();

		conexion = new TCPConnection();

		conexion.setMain(this);
		conexion.start();

	}

	public void draw() {
		background(155, 155, 155);
		
		//Para crear recordatorio

		for (int i = 0; i < recorderis.size(); i++) {
			
			int posX5 = Integer.parseInt(recorderis.get(i).getPosX());
			int posY5 = Integer.parseInt(recorderis.get(i).getPosY());
			fill(255);
			rect(posX5, posY5, 100, 50);
			
			switch (recorderis.get(i).getColor()) {
			case "verde":
				fill(0, 255, 0);
				break;
				
			case "amarillo":
				fill(255, 233, 0);
				break;
				
			case "rojo":
				fill(255, 0, 0);
				break;
			}
			
			ellipse(posX5, posY5 + 25, 25, 25);
			fill(0);
			text(recorderis.get(i).getTexto(), posX5 + 25, posY5 + 30);
			
		}
		
		//Vista Previa
		
		if (vista) {

			fill(255);
			rect(posX, posY, 100, 50);
			
			switch (color) {
			case "verde":
				fill(0, 255, 0);
				break;

			case "amarillo":
				fill(255, 233, 0);
				break;

			case "rojo":
				fill(255, 0, 0);
				break;
			}

			ellipse(posX, posY + 25, 25, 25);
			fill(0);
			text(texto, posX + 25, posY + 30);
		}


	}

	

	public void notificar(Recordatorio recorda) {
		posX = Integer.parseInt(recorda.getPosX());
		posY = Integer.parseInt(recorda.getPosY());
		texto = recorda.getTexto();
		color = recorda.getColor();
		confirmacion = recorda.getConfirmar();

		vista = true;
		
		switch(confirmacion) {
		case "confirmar":
			recorderis.add(new Recordatorio(color, recorda.getPosX(), recorda.getPosY(), texto, confirmacion));
			vista = false;
			break;
			
		
		}

	}
	
	

}
