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
    public Long id;
    @Column(name="name")
    public String name;
    @Column(name="genre")
    public String genre;
    @Column(name="plot")
    public String plot;
    @Column(name="status")
    public boolean status;

    @ManyToOne
    @JoinColumn(name="writer_id", nullable=false)
    public Writer writer;

    @ManyToOne
    @JoinColumn(name="actor", nullable=true)
    public Actor actor;

    @ManyToOne
    @JoinColumn(name="actress", nullable=true)
    public Actor actress;


    public Script(String name, String genre, String plot, Writer writer) {
        this.name = name;
        this.genre = genre;
        this.plot = plot;
        this.writer=writer;
        this.status=false;
        this.actor=new Actor();
        this.actress=new Actor();
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

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Actor getActress() {
        return actress;
    }

    public void setActress(Actor actress) {
        this.actress = actress;
    }
}
