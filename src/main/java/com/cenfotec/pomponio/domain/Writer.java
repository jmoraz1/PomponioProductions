package com.cenfotec.pomponio.domain;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "TWriter")
public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    public String name;
    @Column(name="email")
    public String email;
    @Column(name="address")
    public String address;
    @Column(name="dateOfBirth")
    public Date dateOfBirth;

    @OneToMany(mappedBy="writer")
    private Set<Script> scripts;

    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    public String getCreatedAsShort() {
        return format.format(dateOfBirth);
    }

    public Writer(String name, String email, String address, String dateOfBirth) throws ParseException {
        this.name = name;
        this.email = email;
        this.address = address;
        this.dateOfBirth = format.parse(dateOfBirth);
    }

    public Writer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
