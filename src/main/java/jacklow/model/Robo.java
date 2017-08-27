package jacklow.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import org.uqbarproject.jpa.java8.extras.convert.LocalDateTimeConverter;
@Entity
public class Robo {
	@Id @GeneratedValue
	private Long id;
	
	@Convert(converter = LocalDateTimeConverter.class) /*De tipo de dato definido a un tipo de una base de datos*/
	private LocalDateTime fecha;
	
	@ManyToOne(fetch = FetchType.LAZY
			/*,cascade = CascadeType.PERSIST*/)
	private Vehiculo vehiculo;
	/*Genera la FK - fetchType me define como traigo los datos de la BD*/
	
	//@JoinColumn(name = "robo_id") /*Me crea la FK y no la tabla asociativa*/
	/*Si la entidad ya tiene mas datos de negocios como hora de asignacion,etc
	 * Ya comienza a tener entidad propia, por lo que hay que cosificarla y manejar relaciones un a muchos
	 * con esta entidad Asignacion*/
	@ManyToMany/*Crea la tabla asociativa con las dos FK*/
	@OrderColumn/*Los inserta en el mismo orden que estaban cuando se los persistio*/
	private List<Movil> moviles;
	
	private String denunciante;
	private String operador;
	private String zona;
	private String codigoDenuncia;
	
	public Robo(){
		super();
		this.fecha = LocalDateTime.now();
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public String getDenunciante() {
		return denunciante;
	}

	public String getOperador() {
		return operador;
	}

	public String getZona() {
		return zona;
	}

	public String getCodigoDenuncia() {
		return codigoDenuncia;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

}
