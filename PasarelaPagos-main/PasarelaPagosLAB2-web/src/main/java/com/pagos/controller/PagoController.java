/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagos.controller;

import com.pagos.entity.Pago;
import com.pagos.session.PagoManagerLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author User
 */
@Named(value = "pagoController")
@SessionScoped
public class PagoController implements Serializable {

    @EJB
    private PagoManagerLocal pagoManager;
    private Pago pago;
    private List<Pago> pagos;
    /**
     * Creates a new instance of PagoController
     */
    public PagoController() {
    }
     public List<Pago> getPagos() {
        if ((pagos == null) || (pagos.isEmpty())) {
            refresh();
        }
        return pagos;
    }
    
    public Pago getDetails() {
        return pago;
    }
    public Pago getPago() {
        return pago;
    }
    
    private void refresh() {
        this.pagos = pagoManager.getAllPagos();
    }
    
    public String showDetails(Pago pago) {
        this.pago = pago;
        
        return "PAGAR"; // Permite enlazar a pago.xhtml
    }
    
    public String pagar() {
         return "PAGAR"; // Permite enlazar a pago.xhtml
    }

    
    public String listPagos() {
         return "PAGOS"; // Permite enlazar a pago.xhtml
    }
   
    public String volverPagos(){
    return "PAGO";
    }
}
