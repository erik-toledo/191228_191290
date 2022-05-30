package analizadorLex.pack.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class Analizador {

	public void Analizar(String derivada, AnchorPane pane) {
		String der = derivada;
		String numeroString = "";
		ArrayList<String> tablaKey = new ArrayList<String>(Arrays.asList("F(x)", "+", "-", "/", "$", "=", "x^2", "x"));
		Pattern patron = Pattern.compile("[0-9]+");
		for (int i = 0; i < tablaKey.size(); i++) {
			boolean band = der.contains(tablaKey.get(i));
			if (band) {
				der = Busqueda(der, tablaKey.get(i));

			}
		}
		for (int i = 0; i < der.length(); i++) {
			try {
				Integer.parseInt(Character.toString(der.charAt(i)));
				numeroString += der.charAt(i);
			} catch (Exception e) {
				Matcher validacion = patron.matcher(numeroString);
				if (validacion.find()) {
					der = der.replace(numeroString, ",E,");
				}
				numeroString = "";
			}
		}
		Matcher validacion = patron.matcher(numeroString);
		if (validacion.find()) {
			der = der.replace(numeroString, ",E,");
		}
		ActualizarDatos(der, pane);
	}

	private String Busqueda(String derivada, String key) {
		String nDerivada = "";
		switch (key) {
		case "F(x)":
			nDerivada = derivada.replace(key, ",A,");
			break;
		case "+":
			nDerivada = derivada.replace(key, ",B,");
			break;
		case "-":
			nDerivada = derivada.replace(key, ",B,");
			break;
		case "/":
			nDerivada = derivada.replace(key, ",B,");
			break;
		case "$":
			nDerivada = derivada.replace(key, ",B,");
			break;
		case "=":
			nDerivada = derivada.replace(key, ",B,");
			break;
		case "x":
			nDerivada = derivada.replace(key, ",C,");
			break;
		case "x^2":
			nDerivada = derivada.replace(key, ",D,");
			break;
		}
		return nDerivada;
	}

	public void ActualizarDatos(String derivada, AnchorPane pane) {
		int contador = 0;
		for (int i = 65; i < 70; i++) {
			String caracter = Character.toString((char) i);
			for (int j = 0; j < derivada.length(); j++) {
				if (Character.toString(derivada.charAt(j)).equals(caracter)) {
					contador++;
				}
			}
			for (Node node : pane.getChildren()) {
				if (node instanceof Label) {
					try {
						if (node.getId().equals(caracter)) {
							((Label) node).setText(Integer.toString(contador));
						}
					} catch (Exception e) {
					}
				}
			}
			contador = 0;
		}
		for (int i = 65; i < 70; i++) {
			derivada = derivada.replace(Character.toString((char) i), "");
		}
		derivada = derivada.replace(",", "");
		for (Node node : pane.getChildren()) {
			if (node instanceof Label) {
				try {
					if (node.getId().equals("lblErrores")) {
						((Label) node).setText(derivada);
					}
				} catch (Exception e) {
				}

			}
		}
	}

}
