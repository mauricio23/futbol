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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andrezz
 */
@Entity
@Table(name = "equipo_jugador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipoJugador.findAll", query = "SELECT e FROM EquipoJugador e"),
    @NamedQuery(name = "EquipoJugador.findByIdCampeonatoEquipoJugador", query = "SELECT e FROM EquipoJugador e WHERE e.idCampeonatoEquipoJugador = :idCampeonatoEquipoJugador")})
public class EquipoJugador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_campeonato_equipo_jugador")
    private Integer idCampeonatoEquipoJugador;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo")
    @ManyToOne(optional = false)
    private Equipo idEquipo;
    @JoinColumn(name = "id_jugador", referencedColumnName = "id_jugador")
    @ManyToOne(optional = false)
    private Jugador idJugador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipoJugador")
    private Collection<Gol> golCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipoJugador")
    private Collection<Sancion> sancionCollection;

    public EquipoJugador() {
    }

    public EquipoJugador(Integer idCampeonatoEquipoJugador) {
        this.idCampeonatoEquipoJugador = idCampeonatoEquipoJugador;
    }

    public Integer getIdCampeonatoEquipoJugador() {
        return idCampeonatoEquipoJugador;
    }

    public void setIdCampeonatoEquipoJugador(Integer idCampeonatoEquipoJugador) {
        this.idCampeonatoEquipoJugador = idCampeonatoEquipoJugador;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Jugador getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Jugador idJugador) {
        this.idJugador = idJugador;
    }

    @XmlTransient
    public Collection<Gol> getGolCollection() {
        return golCollection;
    }

    public void setGolCollection(Collection<Gol> golCollection) {
        this.golCollection = golCollection;
    }

    @XmlTransient
    public Collection<Sancion> getSancionCollection() {
        return sancionCollection;
    }

    public void setSancionCollection(Collection<Sancion> sancionCollection) {
        this.sancionCollection = sancionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCampeonatoEquipoJugador != null ? idCampeonatoEquipoJugador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipoJugador)) {
            return false;
        }
        EquipoJugador other = (EquipoJugador) object;
        if ((this.idCampeonatoEquipoJugador == null && other.idCampeonatoEquipoJugador != null) || (this.idCampeonatoEquipoJugador != null && !this.idCampeonatoEquipoJugador.equals(other.idCampeonatoEquipoJugador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.EquipoJugador[ idCampeonatoEquipoJugador=" + idCampeonatoEquipoJugador + " ]";
    }
    
}
