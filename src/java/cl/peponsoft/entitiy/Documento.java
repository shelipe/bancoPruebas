/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.peponsoft.entitiy;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author CFT_Developer
 */
@Entity
@Table(name = "documento")
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d")})
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_doc")
    private Integer idDoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Column(name = "serie")
    private Integer serie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private int monto;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "tipo_doc", referencedColumnName = "cod_doc")
    @ManyToOne(optional = false)
    private DocumentoTipo tipoDoc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documento")
    private List<CuentaMovimiento> cuentaMovimientoList;

    public Documento() {
    }

    public Documento(Integer idDoc) {
        this.idDoc = idDoc;
    }

    public Documento(Integer idDoc, Date fechaIngreso, int monto) {
        this.idDoc = idDoc;
        this.fechaIngreso = fechaIngreso;
        this.monto = monto;
    }

    public Integer getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(Integer idDoc) {
        this.idDoc = idDoc;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DocumentoTipo getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(DocumentoTipo tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public List<CuentaMovimiento> getCuentaMovimientoList() {
        return cuentaMovimientoList;
    }

    public void setCuentaMovimientoList(List<CuentaMovimiento> cuentaMovimientoList) {
        this.cuentaMovimientoList = cuentaMovimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDoc != null ? idDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.idDoc == null && other.idDoc != null) || (this.idDoc != null && !this.idDoc.equals(other.idDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.peponsoft.entitiy.Documento[ idDoc=" + idDoc + " ]";
    }
    
}
