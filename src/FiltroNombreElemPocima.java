
public class FiltroNombreElemPocima implements Filtro{
	private String nombre;
	
	public FiltroNombreElemPocima(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public boolean cumple(ElementoPocima e) {
		// TODO Auto-generated method stub
		return e.getNombre().equals(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
