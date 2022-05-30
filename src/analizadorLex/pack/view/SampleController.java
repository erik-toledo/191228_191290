package analizadorLex.pack.view;

import analizadorLex.pack.model.Analizador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class SampleController {

	@FXML
	private AnchorPane anPnContenedor;

	@FXML
	private TextField txFldDerivada;

	Analizador analizador = new Analizador();

	public void Iniciar(KeyEvent e) {
		if (e.getCode() == KeyCode.ENTER)
			analizador.Analizar(txFldDerivada.getText(), anPnContenedor);
	}

	public void Limpiar(ActionEvent e) {
		int letra = 65;
		txFldDerivada.clear();
		for (Node node : anPnContenedor.getChildren()) {
			for (Node n : anPnContenedor.getChildren()) {
				if (n instanceof Label) {
					try {
						if (n.getId().equals(Character.toString((char) letra)) | n.getId().equals("lblErrores")) {
							((Label) n).setText("0");
						}
					} catch (Exception a) {
					}

				}
			}
			letra++;
		}

	}
}
