/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.peponsoft.facade;

import cl.peponsoft.entitiy.DocumentoTipo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CFT_Developer
 */
@Local
public interface DocumentoTipoFacadeLocal {

    void create(DocumentoTipo documentoTipo);

    void edit(DocumentoTipo documentoTipo);

    void remove(DocumentoTipo documentoTipo);

    DocumentoTipo find(Object id);

    List<DocumentoTipo> findAll();

    List<DocumentoTipo> findRange(int[] range);

    int count();
    
}
