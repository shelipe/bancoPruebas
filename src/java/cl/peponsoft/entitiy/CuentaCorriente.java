/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.peponsoft.entitiy;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author CFT_Developer
 */
@Entity
@Table(name = "cuenta_corriente")
@NamedQueries({
    @NamedQuery(name = "CuentaCorriente.findAll", query = "SELECT c FROM CuentaCorriente c")})
public class CuentaCorriente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuenta")
    private Integer cuenta;
    @Size(max = 50)
    @Column(name = "banco")
    private String banco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo_disponible")
    private int saldoDisponible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo_contable")
    private int saldoContable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sobregiro")
    private int sobregiro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta")
    private List<CuentaMovimiento> cuentaMovimientoList;

    public CuentaCorriente() {
    }

    public CuentaCorriente(Integer cuenta) {
        this.cuenta = cuenta;
    }

    public CuentaCorriente(Integer cuenta, int saldoDisponible, int saldoContable, int sobregiro) {
        this.cuenta = cuenta;
        this.saldoDisponible = saldoDisponible;
        this.saldoContable = saldoContable;
        this.sobregiro = sobregiro;
    }

    public Integer getCuenta() {
        return cuenta;
    }

    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public int getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(int saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public int getSaldoContable() {
        return saldoContable;
    }

    public void setSaldoContable(int saldoContable) {
        this.saldoContable = saldoContable;
    }

    public int getSobregiro() {
        return sobregiro;
    }

    public void setSobregiro(int sobregiro) {
        this.sobregiro = sobregiro;
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
        hash += (cuenta != null ? cuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaCorriente)) {
            return false;
        }
        CuentaCorriente other = (CuentaCorriente) object;
        if ((this.cuenta == null && other.cuenta != null) || (this.cuenta != null && !this.cuenta.equals(other.cuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.peponsoft.entitiy.CuentaCorriente[ cuenta=" + cuenta + " ]";
    }
    
}
