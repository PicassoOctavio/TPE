
public class Atributo {
	private String nombre;
	private int valor;
	
	public Atributo(String nombre, int valor) {
		this.nombre = nombre;
		this.valor = valor;
	}
	
	public boolean equals(Object o) { //EQUALS ATRIBUTO
		try {
			Atributo unAtributo = (Atributo) o;
			if(unAtributo.getNombre()== this.nombre)
				return true;
			else
				return false;
		}
		catch(Exception exc) {
			return false;
		}
	}

	
	public String toString() {
		return this.getNombre() + ": " + this.getValor()+" ";
	}
	
	//SETS AND GETS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	
}
