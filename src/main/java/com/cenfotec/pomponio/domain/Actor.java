package com.cenfotec.pomponio.domain;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "TActor")
public class Actor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="nombre")
	public String nombre;
	@Column(name="genero")
	public String genero;
	@Column(name="fechaNacimiento")
	public Date fechaNacimiento;
	@Column(name="estatura")
	public double estatura;
	@Column(name="complexionCorporal")
	public String complexionCorporal;
	@Column(name="colorOjos")
	public String colorOjos;
	@Column(name="colorPelo")
	public String colorPelo;

	@Transient
	private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	public String getCreatedAsShort() {
		return format.format(fechaNacimiento);
	}

	public Actor(String nombre, String genero, String fechaNacimiento, double estatura, String complexionCorporal, String colorOjos, String colorPelo) throws ParseException {
		this.nombre = nombre;
		this.genero = genero;
		this.fechaNacimiento = format.parse(fechaNacimiento);
		this.estatura = estatura;
		this.complexionCorporal = complexionCorporal;
		this.colorOjos = colorOjos;
		this.colorPelo = colorPelo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public double getEstatura() {
		return estatura;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}

	public String getComplexionCorporal() {
		return complexionCorporal;
	}

	public void setComplexionCorporal(String complexionCorporal) {
		this.complexionCorporal = complexionCorporal;
	}

	public String getColorOjos() {
		return colorOjos;
	}

	public void setColorOjos(String colorOjos) {
		this.colorOjos = colorOjos;
	}

	public String getColorPelo() {
		return colorPelo;
	}

	public void setColorPelo(String colorPelo) {
		this.colorPelo = colorPelo;
	}

	public SimpleDateFormat getFormat() {
		return format;
	}

	public void setFormat(SimpleDateFormat format) {
		this.format = format;
	}
}
