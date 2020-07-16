package com.cenfotec.pomponio.domain;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "TActor")
public class Actor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	public String name;
	@Column(name="gender")
	public String gender;
	@Column(name="dateOfBirth")
	public Date dateOfBirth;
	@Column(name="height")
	public double height;
	@Column(name="built")
	public String built;
	@Column(name="eyeColor")
	public String eyeColor;
	@Column(name="hairColor")
	public String hairColor;
	@ManyToMany
	Set<Script> scripts;

	@Transient
	private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	public String getCreatedAsShort() {
		return format.format(dateOfBirth);
	}

	public Actor(String name, String gender, String dateOfBirth, double height, String built, String eyeColor, String hairColor) throws ParseException {
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = format.parse(dateOfBirth);
		this.height = height;
		this.built = built;
		this.eyeColor = eyeColor;
		this.hairColor = hairColor;
	}

	public Actor() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getBuilt() {
		return built;
	}

	public void setBuilt(String built) {
		this.built = built;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

}
