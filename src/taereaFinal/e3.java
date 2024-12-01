package taereaFinal;

import java.io.IOException;
import java.io.RandomAccessFile;

public class e3 {
public static void main(String[] args) throws IOException {
	RandomAccessFile fichBin = new RandomAccessFile("Paises.dat", "rw");
	String[] pais = { "Belice", "El salvador", "Guatemala", "Honduras", "Nicaragua", "Mexico", "Panama",
	"Costa rica" };
	String[] presidente = { "Froyla Tzalam", "Nayib Bukele", "Alejandro Giammattei", "Xiomara Castro",
	"Daniel Ortega", "Andrés Manuel López Obrador", "Laurentino Cortizo", "Rodrigo Chaves" };
	int[] PIB = { 1987, 74818, 185473, 85626, 47770, 2890685, 128500, 129950 };
	double[] coeficiente = { 53.3, 38.3, 48.3, 48.2, 46.2, 45.4, 50.9, 47.2 };
	
	for (int i = 0; i < coeficiente.length; i++) {
		fichBin.writeUTF(pais[i]);
		fichBin.writeUTF(presidente[i]);
		fichBin.writeInt(PIB[i]);
		fichBin.writeDouble(coeficiente[i]);
		
	}
}
}
