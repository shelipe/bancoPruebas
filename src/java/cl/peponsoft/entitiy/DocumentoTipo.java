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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "documento_tipo")
@NamedQueries({
    @NamedQuery(name = "DocumentoTipo.findAll", query = "SELECT d FROM DocumentoTipo d")})
public class DocumentoTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_doc")
    private Integer codDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "forma")
    private String forma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDoc")
    private List<Documento> documentoList;

    public DocumentoTipo() {
    }

    public DocumentoTipo(Integer codDoc) {
        this.codDoc = codDoc;
    }

    public DocumentoTipo(Integer codDoc, String nombre, String forma) {
        this.codDoc = codDoc;
        this.nombre = nombre;
        this.forma = forma;
    }

    public Integer getCodDoc() {
        return codDoc;
    }

    public void setCodDoc(Integer codDoc) {
        this.codDoc = codDoc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public List<Documento> getDocumentoList() {
        return documentoList;
    }

    public void setDocumentoList(List<Documento> documentoList) {
        this.documentoList = documentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDoc != null ? codDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoTipo)) {
            return false;
        }
        DocumentoTipo other = (DocumentoTipo) object;
        if ((this.codDoc == null && other.codDoc != null) || (this.codDoc != null && !this.codDoc.equals(other.codDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.peponsoft.entitiy.DocumentoTipo[ codDoc=" + codDoc + " ]";
    }
    
}
