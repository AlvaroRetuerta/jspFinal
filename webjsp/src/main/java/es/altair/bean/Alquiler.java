package es.altair.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="alquileres")
public class Alquiler implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAlquiler;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idUser")
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
	public Alquiler(Usuario usuario, Vehiculo vehiculo, Date currentDate, Date date) {
		super();
		this.usuario = usuario;
		this.vehiculo = vehiculo;
		this.fechaInicio = currentDate;
		this.fechaFin = date;
	}
	public int getIdAlquiler() {
		return idAlquiler;
	}
	public void setIdAlquiler(int idAlquiler) {
		this.idAlquiler = idAlquiler;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	@Override
	public String toString() {
		return "Alquiler [idAlquiler=" + idAlquiler + ", usuario=" + usuario + ", vehiculo=" + vehiculo
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
	
	
	
	
}
