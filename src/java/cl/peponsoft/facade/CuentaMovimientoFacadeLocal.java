/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.peponsoft.facade;

import cl.peponsoft.entitiy.CuentaMovimiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CFT_Developer
 */
@Local
public interface CuentaMovimientoFacadeLocal {

    void create(CuentaMovimiento cuentaMovimiento);

    void edit(CuentaMovimiento cuentaMovimiento);

    void remove(CuentaMovimiento cuentaMovimiento);

    CuentaMovimiento find(Object id);

    List<CuentaMovimiento> findAll();

    List<CuentaMovimiento> findRange(int[] range);

    int count();
    
}
