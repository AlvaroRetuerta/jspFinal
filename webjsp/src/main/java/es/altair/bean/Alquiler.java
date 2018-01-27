package es.altair.bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="alquileres")
public class Alquiler {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAlquiler;
	private int idUsuario;
	private int idVehiculo;
	private Date fechaInicio;
	private Date fechaFin;
	public Alquiler() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Alquiler(int idUsuario, int idVehiculo, Date fechaInicio, Date fechaFin) {
		super();
		this.idUsuario = idUsuario;
		this.idVehiculo = idVehiculo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	public int getIdAlquiler() {
		return idAlquiler;
	}
	public void setIdAlquiler(int idAlquiler) {
		this.idAlquiler = idAlquiler;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
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
		return "Alquiler [idAlquiler=" + idAlquiler + ", idUsuario=" + idUsuario + ", idVehiculo=" + idVehiculo
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
	
	
	
	
}
