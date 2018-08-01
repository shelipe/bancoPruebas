/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.peponsoft.facade;

import cl.peponsoft.entitiy.DocumentoTipo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CFT_Developer
 */
@Stateless
public class DocumentoTipoFacade extends AbstractFacade<DocumentoTipo> implements DocumentoTipoFacadeLocal {

    @PersistenceContext(unitName = "bancoPruebasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocumentoTipoFacade() {
        super(DocumentoTipo.class);
    }
    
}
