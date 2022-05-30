package analizadorLex.pack.model;

public class TablaKeys {

	private String suma;
	private String resta;
	private String fraccion;
	private String raiz;
	private String igual;
	private String funcion;
	private String variable;
	private String variableCuadratica;

	public TablaKeys(String suma, String resta, String fraccion, String raiz, String igual, String funcion,
			String variable, String variableCuadratica) {
		super();
		this.suma = suma;
		this.resta = resta;
		this.fraccion = fraccion;
		this.raiz = raiz;
		this.igual = igual;
		this.funcion = funcion;
		this.variable = variable;
		this.variableCuadratica = variableCuadratica;
	}

	/*-------------------------------Setter's y Getter's------------------------------------------------*/

	public String getSuma() {
		return suma;
	}

	public void setSuma(String suma) {
		this.suma = suma;
	}

	public String getResta() {
		return resta;
	}

	public void setResta(String resta) {
		this.resta = resta;
	}

	public String getFraccion() {
		return fraccion;
	}

	public void setFraccion(String fraccion) {
		this.fraccion = fraccion;
	}

	public String getRaiz() {
		return raiz;
	}

	public void setRaiz(String raiz) {
		this.raiz = raiz;
	}

	public String getIgual() {
		return igual;
	}

	public void setIgual(String igual) {
		this.igual = igual;
	}

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	public String getVariableCuadratica() {
		return variableCuadratica;
	}

	public void setVariableCuadratica(String variableCuadratica) {
		this.variableCuadratica = variableCuadratica;
	}
}
