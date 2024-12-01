package taereaFinal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListaPaises {

		private List<Pais> lista = new ArrayList<Pais>();

		public ListaPaises() throws IOException, ClassNotFoundException {}
	

		public void add(Pais a) {
			lista.add(a);
		}

		public List<Pais> getListaPaises() {
			return lista;
		}
	}
