package es.altair.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="alquileres")
public class Alquiler implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAlquiler;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idUsuario")
	private Usuario usuario;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idVehiculo")
	private Vehiculo vehiculo;

	private Date fechaInicio;

	private Date fechaFin;
	public Alquiler() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Alquiler(Usuario usuario, Vehiculo vehiculo, Date fechaInicio, Date fechaFin) {
		super();
		this.usuario = usuario;
		this.vehiculo = vehiculo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	
}
