/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.peponsoft.facade;

import cl.peponsoft.entitiy.CuentaMovimiento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CFT_Developer
 */
@Stateless
public class CuentaMovimientoFacade extends AbstractFacade<CuentaMovimiento> implements CuentaMovimientoFacadeLocal {

    @PersistenceContext(unitName = "bancoPruebasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentaMovimientoFacade() {
        super(CuentaMovimiento.class);
    }
    
}
