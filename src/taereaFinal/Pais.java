package taereaFinal;

import java.io.Serializable;

public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;
	public String Pais;
	public String presidente;
	public int PIB;
	public double coeficiente;

	public Pais(String Pais, String presidente, int pIB, double coeficiente) {
		super();
		this.Pais = Pais;
		this.presidente = presidente;
		this.PIB = pIB;
		this.coeficiente = coeficiente;
	}
	public Pais() {
		
	}

	public String getPais() {
		return Pais;
	}

	public void setPais(String Pais) {
		this.Pais = Pais;
	}

	public String getPresidente() {
		return presidente;
	}

	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}

	public int getPIB() {
		return PIB;
	}

	public void setPIB(int pIB) {
		this.PIB = pIB;
	}

	public double getCoeficiente() {
		return coeficiente;
	}

	public void setCoeficiente(double coeficiente) {
		this.coeficiente = coeficiente;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "datos [pais=" + Pais + ", presidente=" + presidente + ", PIB=" + PIB + ", coeficiente=" + coeficiente
				+ "]";
	}
	

}
