package com.example.model;
// Generated 12-mar-2019 14:12:29 by Hibernate Tools 4.3.1


import java.sql.Date;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CampusFP
 */
@Entity
@Table(name = "Alumno")
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    @Basic(optional = false)
    @Column(name = "FECHA_NAC")
    private Date fechaNac;
    private Float media;
    private Boolean aprobado;
    @JoinColumn(name = "ID_CLASE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Clase idClase;

    public Alumno() {
    }

    
    public Alumno(Integer id) {
        this.id = id;
    }

    public Alumno(Integer id, String nombre, String apellido, Date fechaNac) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Float getMedia() {
        return media;
    }

    public void setMedia(Float media) {
        this.media = media;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    public Clase getIdClase() {
        return idClase;
    }

    public void setIdClase(Clase idClase) {
        this.idClase = idClase;
    }

    

    @Override
    public String toString() {
        return "modelo.Alumno[ id=" + id + " ]";
    }
    
}