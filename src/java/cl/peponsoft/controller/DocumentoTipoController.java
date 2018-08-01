package cl.peponsoft.controller;

import cl.peponsoft.entitiy.DocumentoTipo;
import cl.peponsoft.facade.DocumentoTipoFacadeLocal;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("dTipoCtrl")
@ViewScoped
public class DocumentoTipoController implements Serializable {

    @EJB
    private DocumentoTipoFacadeLocal dTipoEJB;

    private DocumentoTipo documentoTipo;
    private List<DocumentoTipo> listaTiposDocumentos;

    public DocumentoTipoController() {
        documentoTipo = new DocumentoTipo();
        listaTiposDocumentos = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        cargarListaTiposDocumentos();
    }

    public DocumentoTipo getDocumentoTipo() {
        return documentoTipo;
    }

    public void setDocumentoTipo(DocumentoTipo documentoTipo) {
        this.documentoTipo = documentoTipo;
    }

    public List<DocumentoTipo> getListaTiposDocumentos() {
        return listaTiposDocumentos;
    }

    public void setListaTiposDocumentos(List<DocumentoTipo> listaTiposDocumentos) {
        this.listaTiposDocumentos = listaTiposDocumentos;
    }

    public void cargarListaTiposDocumentos() {
        listaTiposDocumentos = dTipoEJB.findAll();
    }
}
