/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.peponsoft.facade;

import cl.peponsoft.entitiy.CuentaCorriente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CFT_Developer
 */
@Local
public interface CuentaCorrienteFacadeLocal {

    void create(CuentaCorriente cuentaCorriente);

    void edit(CuentaCorriente cuentaCorriente);

    void remove(CuentaCorriente cuentaCorriente);

    CuentaCorriente find(Object id);

    List<CuentaCorriente> findAll();

    List<CuentaCorriente> findRange(int[] range);

    int count();
    
}
