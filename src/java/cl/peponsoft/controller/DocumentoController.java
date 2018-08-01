package cl.peponsoft.controller;

import cl.peponsoft.entitiy.CuentaCorriente;
import cl.peponsoft.entitiy.CuentaMovimiento;
import cl.peponsoft.entitiy.Documento;
import cl.peponsoft.entitiy.DocumentoTipo;
import cl.peponsoft.facade.CuentaCorrienteFacadeLocal;
import cl.peponsoft.facade.CuentaMovimientoFacadeLocal;
import cl.peponsoft.facade.DocumentoFacadeLocal;
import cl.peponsoft.facade.DocumentoTipoFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Controlador para ingreso de documentos de una determinada cuenta donde se
 * ingresara el documento dependiendo del tipo, luego quedara registrado en el
 * movieminto de cuenta corriente elejida y hara los ingresos y egresos de los
 * saldos cuenta.
 * @author PeponSoft
 */

@Named("doumentoCtrl")
@ViewScoped
public class DocumentoController implements Serializable {

    @EJB
    private CuentaCorrienteFacadeLocal ctaCteEJB;
    @EJB
    private CuentaMovimientoFacadeLocal ctaMovEJB;
    @EJB
    private DocumentoFacadeLocal documentoEJB;
    @EJB
    private DocumentoTipoFacadeLocal dTipoEJB;

    @Inject
    private CuentaMovimiento cuentaMovimiento;
    @Inject
    private Documento documento;
    @Inject
    private CuentaCorriente cuentaCorriente;
    @Inject
    private DocumentoTipo documentoTipo;

    private List<CuentaCorriente> listadoCtasCtes;
    private List<DocumentoTipo> listadoTiposDocumentos;
    private int numeroCuenta;

    public DocumentoController() {
        listadoCtasCtes = new ArrayList<>();
        listadoTiposDocumentos = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        cargarListas();
    }

    public void cargarListas() {
        listadoCtasCtes.clear();
        listadoTiposDocumentos.clear();
        listadoCtasCtes = ctaCteEJB.findAll();
        listadoTiposDocumentos = dTipoEJB.findAll();
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public List<DocumentoTipo> getListadoTiposDocumentos() {
        return listadoTiposDocumentos;
    }

    public void setListadoTiposDocumentos(List<DocumentoTipo> listadoTiposDocumentos) {
        this.listadoTiposDocumentos = listadoTiposDocumentos;
    }

    public DocumentoTipo getDocumentoTipo() {
        return documentoTipo;
    }

    public void setDocumentoTipo(DocumentoTipo documentoTipo) {
        this.documentoTipo = documentoTipo;
    }

    public CuentaMovimiento getCuentaMovimiento() {
        return cuentaMovimiento;
    }

    public void setCuentaMovimiento(CuentaMovimiento cuentaMovimiento) {
        this.cuentaMovimiento = cuentaMovimiento;
    }

    public List<CuentaCorriente> getListadoCtasCtes() {
        return listadoCtasCtes;
    }

    public void setListadoCtasCtes(List<CuentaCorriente> listadoCtasCtes) {
        this.listadoCtasCtes = listadoCtasCtes;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void addMessageError(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * Metodo Registrar Ingreso el documento y el moviemiento el la cuenta
     * corriente
     * @param actionEvent
     */
    public void registrarIngreso(ActionEvent actionEvent){
        try {
            //Crea el documento Emitido
            documento.setTipoDoc(documentoTipo);
            documentoEJB.create(documento);
            //Registra el movimiento de la cuenta corriente selecionada en combobox
            cuentaMovimiento.setCuenta(cuentaCorriente);
            int monto = documento.getMonto();
            cuentaMovimiento.setDocumento(documento);
            cuentaMovimiento.setMonto(monto);
            cuentaMovimiento.setTipoMov("I");
            ctaMovEJB.create(cuentaMovimiento);
            operacionSaldoCuenta();
            //Mensajes de ingreso y metodos para limpiar variables
            addMessage("Transacción realizada y registrada !!");
            limpiarVariables();
            cargarListas();
        } catch (Exception e) {
            addMessage(e.getMessage() + e.toString());
        }
    }

    /**
     * Metodo para realizar calculos en la cuenta corriente, dependiendo si es
     * ingreso o egreso
     */
    public void operacionSaldoCuenta() {
        int sDisponible = 0;
        numeroCuenta = cuentaCorriente.getCuenta();
        try {
            this.cuentaCorriente = this.ctaCteEJB.find(numeroCuenta);
            sDisponible = this.cuentaCorriente.getSaldoDisponible();
            if ("I".equals(this.cuentaMovimiento.getTipoMov())) {
                sDisponible += this.documento.getMonto();
            } else {
                sDisponible -= this.documento.getMonto();
            }
            this.cuentaCorriente.setSaldoDisponible(sDisponible);
            ctaCteEJB.edit(cuentaCorriente);
        } catch (Exception e) {
            addMessage(e.getMessage() + e.toString());
        }

    }

    public void limpiarVariables() {
        this.documento.setMonto(0);
        this.documento.setFechaIngreso(null);
        this.documento.setNombre(null);
        this.documento.setSerie(null);
    }

}
