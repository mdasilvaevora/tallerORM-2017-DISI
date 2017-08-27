package jacklow.model.eventos;

import javax.persistence.Entity;

@Entity
public class PistaEncontrada extends Evento {
	private String descripcion;

	public PistaEncontrada() {
	}
	
	public PistaEncontrada(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	
}
