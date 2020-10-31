
public abstract class ElementoPocima {
	private String nombre;
	
	public ElementoPocima(String nombre) {
		this.nombre = nombre;
	}
	
	public abstract boolean getCantMinimaPocimas();
	public abstract boolean cumple(Filtro f);
	public abstract int modificarAtributo(int valorAtributo, String nombreAtributo);
	
	//si for 
	/*public boolean cumpleCantMin(Filtro f){
		int cant = 0;
		for (ElementoPocima elem : pocimas){
			if (f.cumple(this))
				cant++;
				if (cant == 2)
					return true;
		
		}
		return false;
	}
	 */
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	// abstract getCantMinimaPocimas
	//por cada elementoPocima, si por cada elementoPocima la cant minima es mayor a dos getCantPocima return 1;
	
	//public boolean cumple();
}
