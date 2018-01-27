package es.altair.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="vehiculos")

public class Vehiculo implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVehiculo;
	@Size(min=7, max=7)
	private String matricula;
	private String marca;
	private String modelo;
	private int año;
	private String pais;
	private byte[] imagen;
	
	@OneToMany
	Set<Alquiler> alquileres= new HashSet<Alquiler>();
	
	public Vehiculo(String matricula, String marca, String modelo, int año, String pais) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.año = año;
		this.pais = pais;

	}

	public String getMatricula() {
		return matricula;
	}

	public Set<Alquiler> getAlquileres() {
		return alquileres;
	}

	public void setAlquileres(Set<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public int getId() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public Vehiculo() {
		super();
	}

	@Override
	public String toString() {
		return "Vehiculo [idVehiculo=" + idVehiculo + ", matricula=" + matricula + ", marca=" + marca + ", modelo="
				+ modelo + ", año=" + año + ", pais=" + pais + ", imagen=" + Arrays.toString(imagen) + "]";
	}

	
	
	
	
}
