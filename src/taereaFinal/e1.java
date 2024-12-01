package taereaFinal;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class e1 {
	public static void main(String[] args)
			throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		DOMImplementation implementation = builder.getDOMImplementation();
		Document document = implementation.createDocument(null, "ListaPaises", null);
		document.setXmlVersion("1.0");
		String[] pais = { "Belice", "El salvador", "Guatemala", "Honduras", "Nicaragua", "Mexico", "Panama",
				"Costa rica" };
		String[] presidente = { "Froyla Tzalam", "Nayib Bukele", "Alejandro Giammattei", "Xiomara Castro",
				"Daniel Ortega", "Andrés Manuel López Obrador", "Laurentino Cortizo", "Rodrigo Chaves" };
		int[] PIB = { 1987, 74818, 185473, 85626, 47770, 2890685, 128500, 129950 };
		double[] coeficiente = { 53.3, 38.3, 48.3, 48.2, 46.2, 45.4, 50.9, 47.2 };
		

		for (int i = 0; i < coeficiente.length; i++) {

			Element Pais = document.createElement("datos");
			document.getDocumentElement().appendChild(Pais);

			Element elemFinal = document.createElement("pais");
			Text text = document.createTextNode(pais[i]);
			Pais.appendChild(elemFinal);
			elemFinal.appendChild(text);

			elemFinal = document.createElement("presidente");
			text = document.createTextNode(presidente[i]);
			Pais.appendChild(elemFinal);
			elemFinal.appendChild(text);

			elemFinal = document.createElement("PIB");
			text = document.createTextNode(String.valueOf(PIB[i]));
			Pais.appendChild(elemFinal);
			elemFinal.appendChild(text);

			elemFinal = document.createElement("coeficiente");
			text = document.createTextNode(String.valueOf(coeficiente[i]));
			Pais.appendChild(elemFinal);
			elemFinal.appendChild(text);

		}

		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

		Source source = new DOMSource(document);
		Result result = new StreamResult(new File("Paises.xml"));
		transformer.transform(source, result);

		
		Result console = new StreamResult(System.out);
		transformer.transform(source, console);
	}
}
