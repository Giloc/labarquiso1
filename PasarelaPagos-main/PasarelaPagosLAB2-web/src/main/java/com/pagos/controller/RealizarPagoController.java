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
import java.time.LocalDateTime;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author User
 */
@Named(value = "realizarPagoController")
@SessionScoped
public class RealizarPagoController implements Serializable {

    @EJB
    private com.pagos.session.PagoManagerLocal pagoManager;
    
    /**
     * Creates a new instance of RealizarPagoController
     */
    public RealizarPagoController() {
    }
    private Pago pago;
    private String imagenTarj;
    @Size(min=2,max=10)
    private String  id_cliente;
    @Size(min=2,max=30)
    private String nom_cliente;
    @Size(min=2,max=30)
    private String apell_cliente;
    @Size(min=7,max=60)
    private String email_cliente;
    @Size(min=5,max=16)
    private String num_tar;
    @Size(min=3,max=3)
    private String csv_tar;
    @Min(500) @Max(10000) @NotNull
    private Double valor_pago;
    private String fecha_pago;
    @Size(min=4,max=10)
    private String tipo_tar;
    @Size(min=5,max=10)
    private String expiracion_tarj;

    public PagoManagerLocal getPagoManager() {
        return pagoManager;
    }

    public void setPagoManager(PagoManagerLocal pagoManager) {
        this.pagoManager = pagoManager;
    }
    

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago Pago) {
        this.pago = Pago;
    }

    public String getImagenTarj() {
        return imagenTarj;
    }

    public void setImagenTarj(String imagenTarj) {
        this.imagenTarj = imagenTarj;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNom_cliente() {
        return nom_cliente;
    }

    public void setNom_cliente(String nom_cliente) {
        this.nom_cliente = nom_cliente;
    }

    public String getApell_cliente() {
        return apell_cliente;
    }

    public void setApell_cliente(String apell_cliente) {
        this.apell_cliente = apell_cliente;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public String getNum_tar() {
        return num_tar;
    }

    public void setNum_tar(String num_tar) {
        this.num_tar = num_tar;
    }

    public String getCsv_tar() {
        return csv_tar;
    }

    public void setCsv_tar(String csv_tar) {
        this.csv_tar = csv_tar;
    }

    public Double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(Double valor_pago) {
        this.valor_pago = valor_pago;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getTipo_tar() {
        return tipo_tar;
    }

    public void setTipo_tar(String tipo_tar) {
        this.tipo_tar = tipo_tar;
    }

    public String getExpiracion_tarj() {
        return expiracion_tarj;
    }

    public void setExpiracion_tarj(String expiracion_tarj) {
        this.expiracion_tarj = expiracion_tarj;
    }
    
    public String guardarBBDD(){
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correct", "Correct");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        Pago pagoG=new Pago();
        LocalDateTime locaDate = LocalDateTime.now();
        int day= locaDate.getDayOfMonth();
        int month = locaDate.getMonthValue();
        int year=locaDate.getYear();
        fecha_pago=day+"-"+month+"-"+year;
        pagoG.setIdCliente(id_cliente);
        pagoG.setNomCliente(nom_cliente);
        pagoG.setApellCliente(apell_cliente);
        pagoG.setEmailCliente(email_cliente);
        pagoG.setNumTar(num_tar);
        pagoG.setTipoTar(tipo_tar);
        pagoG.setCsvTar(csv_tar);
        pagoG.setExpiracionTarj(expiracion_tarj);
        pagoG.setValorPago(valor_pago);
        pagoG.setFechaPago(fecha_pago);
        pagoManager.saveDatabase(pagoG);
        this.pago=pagoG;
        return "DATOS PAGO";
    }
    public void validartarjeta(){
        if(num_tar.length()>=5){
            String valor=num_tar.substring(0, 5);
            int numero=Integer.parseInt(valor);
            if(numero>=11111 && numero<=22222){
                tipo_tar="AMERICAN EXPRESS";
                this.imagenTarj="Img/tarjetas/american.png";
            }else if(numero>=33334 && numero<=44444){
                tipo_tar="DINERS";
                this.imagenTarj="Img/tarjetas/diners.png";
            }else if(numero>=55555&& numero<=66666){
                tipo_tar="VISA";
                this.imagenTarj="Img/tarjetas/visa.png";
            }else if( numero>=77777 && numero<=88888){
                tipo_tar="MASTERCARD";
                this.imagenTarj="Img/tarjetas/mastercard.png";
            }else{
                tipo_tar="OTRA";
                this.imagenTarj="Img/tarjetas/otra.png";
            }
        }
    }
}
