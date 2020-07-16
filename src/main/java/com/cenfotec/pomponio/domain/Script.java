package com.cenfotec.pomponio.domain;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "TScript")
public class Script {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    public String name;
    @Column(name="genre")
    public String genre;
    @Column(name="plot")
    public String plot;
    @Column(name="status")
    public boolean status;

    @ManyToOne
    @JoinColumn(name="writer_id", nullable=true)
    private Writer writer;

    @ManyToMany
    Set<Actor> actors;


    public Script(String name, String genre, String plot, Writer writer) {
        this.name = name;
        this.genre = genre;
        this.plot = plot;
        this.writer=writer;
        this.status=false;
        this.actors=null;
    }

    public Script() {
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }
}
