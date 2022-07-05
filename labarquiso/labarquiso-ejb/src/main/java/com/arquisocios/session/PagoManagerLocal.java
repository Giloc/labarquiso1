/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arquisocios.session;

import com.arquisocios.entity.Pago;
import javax.ejb.Local;

/**
 *
 * @author USER
 */
@Local
public interface PagoManagerLocal {

    void save(Pago pago);
    
}
