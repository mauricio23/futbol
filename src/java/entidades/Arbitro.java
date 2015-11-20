/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andrezz
 */
@Entity
@Table(name = "arbitro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arbitro.findAll", query = "SELECT a FROM Arbitro a"),
    @NamedQuery(name = "Arbitro.findByIdArbitro", query = "SELECT a FROM Arbitro a WHERE a.idArbitro = :idArbitro"),
    @NamedQuery(name = "Arbitro.findByNombres", query = "SELECT a FROM Arbitro a WHERE a.nombres = :nombres"),
    @NamedQuery(name = "Arbitro.findByApellidos", query = "SELECT a FROM Arbitro a WHERE a.apellidos = :apellidos"),
    @NamedQuery(name = "Arbitro.findByFechaNacimiento", query = "SELECT a FROM Arbitro a WHERE a.fechaNacimiento = :fechaNacimiento")})
public class Arbitro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_arbitro")
    private Integer idArbitro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "central")
    private Collection<Partido> partidoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "juez1")
    private Collection<Partido> partidoCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "juez2")
    private Collection<Partido> partidoCollection2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "juez3")
    private Collection<Partido> partidoCollection3;

    public Arbitro() {
    }

    public Arbitro(Integer idArbitro) {
        this.idArbitro = idArbitro;
    }

    public Arbitro(Integer idArbitro, String nombres, String apellidos, String fechaNacimiento) {
        this.idArbitro = idArbitro;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getIdArbitro() {
        return idArbitro;
    }

    public void setIdArbitro(Integer idArbitro) {
        this.idArbitro = idArbitro;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @XmlTransient
    public Collection<Partido> getPartidoCollection() {
        return partidoCollection;
    }

    public void setPartidoCollection(Collection<Partido> partidoCollection) {
        this.partidoCollection = partidoCollection;
    }

    @XmlTransient
    public Collection<Partido> getPartidoCollection1() {
        return partidoCollection1;
    }

    public void setPartidoCollection1(Collection<Partido> partidoCollection1) {
        this.partidoCollection1 = partidoCollection1;
    }

    @XmlTransient
    public Collection<Partido> getPartidoCollection2() {
        return partidoCollection2;
    }

    public void setPartidoCollection2(Collection<Partido> partidoCollection2) {
        this.partidoCollection2 = partidoCollection2;
    }

    @XmlTransient
    public Collection<Partido> getPartidoCollection3() {
        return partidoCollection3;
    }

    public void setPartidoCollection3(Collection<Partido> partidoCollection3) {
        this.partidoCollection3 = partidoCollection3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArbitro != null ? idArbitro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arbitro)) {
            return false;
        }
        Arbitro other = (Arbitro) object;
        if ((this.idArbitro == null && other.idArbitro != null) || (this.idArbitro != null && !this.idArbitro.equals(other.idArbitro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Arbitro[ idArbitro=" + idArbitro + " ]";
    }
    
}
