
public abstract class Pocima {
	private String nombre;
	
	public Pocima(String nombre) {
		this.nombre = nombre;
	}
	
	public abstract int modificarValor(Atributo atributo);

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
