package main;

public class Recordatorio {
    private String color, posX, posY, texto, confirmar;

    public Recordatorio(String color, String posX, String posY, String texto, String confirmar){
        this.color = color;
        this.posX = posX;
        this.posY = posY;
        this.texto = texto;
        this.confirmar = confirmar;
    }

	public String getConfirmar() {
		return confirmar;
	}

	public void setConfirmar(String confirmar) {
		this.confirmar = confirmar;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPosX() {
		return posX;
	}

	public void setPosX(String posX) {
		this.posX = posX;
	}

	public String getPosY() {
		return posY;
	}

	public void setPosY(String posY) {
		this.posY = posY;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
}
