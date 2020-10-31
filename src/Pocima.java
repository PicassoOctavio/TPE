
public class Pocima extends ElementoPocima {
	private int valor;
	
	public Pocima(String nombre, int valor) {
		super(nombre);
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	@Override
	public int modificarAtributo(int valorAtributo, String nombreAtributo) {
		if(compararValorFijo())
			return valorAtributo = this.getValor();
		if(compararIncremetadoras()) {
			return valorAtributo += valorAtributo * this.getValor() / 100;
		}
		if(compararReductoras()) {
			return valorAtributo -= valorAtributo * this.getValor() / 100;
		}
		if(compararSelectivas(nombreAtributo)) {
			return valorAtributo += valorAtributo * this.getValor() / 100;
		}
		else
			return 0;
	}	
	
	public boolean compararValorFijo() {
		if(this.getNombre().equals("vale cuatro") || this.getNombre().equals("numero magico"))
			return true;
		else
			return false;
	}
	public boolean compararIncremetadoras() {
		if(this.getNombre().equals("fortalecedora") || this.getNombre().equals("fortalecedora plus"))
			return true;
		else
			return false;
	}
	public boolean compararReductoras() {
		if(this.getNombre().equals("kriptonita") || this.getNombre().equals("reductor de plomo"))
			return true;
		else
			return false;
	}
	
	public boolean compararSelectivas(String nombreAtributo) {
		if((nombreAtributo.equals("peso") || nombreAtributo.equals("fuerza")) &&
				(this.getNombre().equals("pocima selectiva fuerza") 
						|| this.getNombre().equals("pocima selectiva peso")))
			return true;
		else
			return false;
	}
	
	
	
	
	public boolean equals(Object o) {
		try {
			Pocima p = (Pocima) o;
			if(super.getNombre().equals(p.getNombre()) &&
					this.valor == p.getValor())
				return true;
			else
				return false;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean getCantMinimaPocimas() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cumple(Filtro f) {
		// TODO Auto-generated method stub
		return false;
	}
}
