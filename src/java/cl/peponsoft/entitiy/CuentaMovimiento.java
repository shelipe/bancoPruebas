/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.peponsoft.entitiy;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "cuenta_movimiento")
@NamedQueries({
    @NamedQuery(name = "CuentaMovimiento.findAll", query = "SELECT c FROM CuentaMovimiento c")})
public class CuentaMovimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mov")
    private Integer idMov;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_mov", insertable = false)
    private Date fechaMov;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private int monto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tipo_mov")
    private String tipoMov;
    @JoinColumn(name = "cuenta", referencedColumnName = "cuenta")
    @ManyToOne(optional = false)
    private CuentaCorriente cuenta;
    @JoinColumn(name = "documento", referencedColumnName = "id_doc")
    @ManyToOne(optional = false,cascade = CascadeType.PERSIST)
    private Documento documento;

    public CuentaMovimiento() {
    }

    public CuentaMovimiento(Integer idMov) {
        this.idMov = idMov;
    }

    public CuentaMovimiento(Integer idMov, int monto, String tipoMov) {
        this.idMov = idMov;
        this.monto = monto;
        this.tipoMov = tipoMov;
    }

    public Integer getIdMov() {
        return idMov;
    }

    public void setIdMov(Integer idMov) {
        this.idMov = idMov;
    }

    public Date getFechaMov() {
        return fechaMov;
    }

    public void setFechaMov(Date fechaMov) {
        this.fechaMov = fechaMov;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(String tipoMov) {
        this.tipoMov = tipoMov;
    }

    public CuentaCorriente getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaCorriente cuenta) {
        this.cuenta = cuenta;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMov != null ? idMov.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaMovimiento)) {
            return false;
        }
        CuentaMovimiento other = (CuentaMovimiento) object;
        if ((this.idMov == null && other.idMov != null) || (this.idMov != null && !this.idMov.equals(other.idMov))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.peponsoft.entitiy.CuentaMovimiento[ idMov=" + idMov + " ]";
    }
    
}
