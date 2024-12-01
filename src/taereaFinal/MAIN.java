package taereaFinal;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

public class MAIN {
	public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
//		XStream xstream = new XStream();
//		xstream.addPermission(NoTypePermission.NONE);
//		xstream.addPermission(NullPermission.NULL);
//		xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
//		Class[] clases = { ListaPaises.class, datos.class };
//		xstream.allowTypes(clases);
//		xstream.allowTypesByWildcard(new String[] { "com.your.package.*" });
//
//		xstream.alias("ListaPaises", ListaPaises.class);
//		xstream.alias("datos", datos.class); // Asegúrate de usar "datos" como el alias si así lo definiste
//		xstream.addImplicitCollection(ListaPaises.class, "lista");
//
//		FileInputStream fichero = new FileInputStream("paisesTotal.xml");
//		ListaPaises list = (ListaPaises) xstream.fromXML(fichero);
//		fichero.close();
//		ObjectContainer bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "PaisesGuardados.yap");
//		ObjectSet<paiss> result = bd.queryByExample(ejemplo);
		Pais ejemplo = new Pais();

		daoMetodos dao = new daoMetodos();
		dao.CrearTablaAlumnos();

//		for (paiss dat : result) {
//			dao.guardarAlumno(dat);
//		}

	

		// int[] PIB = { 1987, 74818, 185473, 85626, 47770, 2890685, 128500, 129950 };
		dao.modificarPIB(1987, 10_001_987);
		dao.modificarPIB(74818, 10_074_818);
		dao.modificarPIB(185473, 10_185_473);
		dao.modificarPIB(85626, 10_085_626);
		dao.modificarPIB(47770, 10_047_770);
		dao.modificarPIB(2890685, 12_890_685);
		dao.modificarPIB(128500, 10_128_500);
		dao.modificarPIB(129950, 10_129_950);

		// String[] pais = { "Belice", "El salvador", "Guatemala", "Honduras",
		// "Nicaragua", "Mexico", "Panama","Costa rica" };
		// double[] coeficiente = { 53.3, 38.3, 48.3, 48.2, 46.2, 45.4, 50.9, 47.2 };

		dao.modificarCoeficiente(38.3, 25.53);
		dao.modificarCoeficiente(48.2, 32.13);
		dao.modificarCoeficiente(45.4, 30.27);

	}
}
