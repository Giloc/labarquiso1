/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arquisocios.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p"),
    @NamedQuery(name = "Pago.findByIdCliente", query = "SELECT p FROM Pago p WHERE p.idCliente = :idCliente"),
    @NamedQuery(name = "Pago.findByNomCliente", query = "SELECT p FROM Pago p WHERE p.nomCliente = :nomCliente"),
    @NamedQuery(name = "Pago.findByApellCliente", query = "SELECT p FROM Pago p WHERE p.apellCliente = :apellCliente"),
    @NamedQuery(name = "Pago.findByNumTar", query = "SELECT p FROM Pago p WHERE p.numTar = :numTar"),
    @NamedQuery(name = "Pago.findByCSVtar", query = "SELECT p FROM Pago p WHERE p.cSVtar = :cSVtar"),
    @NamedQuery(name = "Pago.findByTipoTar", query = "SELECT p FROM Pago p WHERE p.tipoTar = :tipoTar"),
    @NamedQuery(name = "Pago.findByExpiracionTarj", query = "SELECT p FROM Pago p WHERE p.expiracionTarj = :expiracionTarj"),
    @NamedQuery(name = "Pago.findByValorPago", query = "SELECT p FROM Pago p WHERE p.valorPago = :valorPago"),
    @NamedQuery(name = "Pago.findByFechaPago", query = "SELECT p FROM Pago p WHERE p.fechaPago = :fechaPago"),
    @NamedQuery(name = "Pago.findByEmailCliente", query = "SELECT p FROM Pago p WHERE p.emailCliente = :emailCliente"),
    @NamedQuery(name = "Pago.findByIdPago", query = "SELECT p FROM Pago p WHERE p.idPago = :idPago")})
public class Pago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "id_cliente")
    private String idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_cliente")
    private String nomCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "apell_cliente")
    private String apellCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "num_tar")
    private String numTar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CSV_tar")
    private String cSVtar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tipo_tar")
    private String tipoTar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "expiracion_tarj")
    private String expiracionTarj;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_pago")
    private double valorPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "fecha_pago")
    private String fechaPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "email_cliente")
    private String emailCliente;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago")
    private Integer idPago;

    public Pago() {
    }

    public Pago(Integer idPago) {
        this.idPago = idPago;
    }

    public Pago(Integer idPago, String idCliente, String nomCliente, String apellCliente, String numTar, String cSVtar, String tipoTar, String expiracionTarj, double valorPago, String fechaPago, String emailCliente) {
        this.idPago = idPago;
        this.idCliente = idCliente;
        this.nomCliente = nomCliente;
        this.apellCliente = apellCliente;
        this.numTar = numTar;
        this.cSVtar = cSVtar;
        this.tipoTar = tipoTar;
        this.expiracionTarj = expiracionTarj;
        this.valorPago = valorPago;
        this.fechaPago = fechaPago;
        this.emailCliente = emailCliente;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getApellCliente() {
        return apellCliente;
    }

    public void setApellCliente(String apellCliente) {
        this.apellCliente = apellCliente;
    }

    public String getNumTar() {
        return numTar;
    }

    public void setNumTar(String numTar) {
        this.numTar = numTar;
    }

    public String getCSVtar() {
        return cSVtar;
    }

    public void setCSVtar(String cSVtar) {
        this.cSVtar = cSVtar;
    }

    public String getTipoTar() {
        return tipoTar;
    }

    public void setTipoTar(String tipoTar) {
        this.tipoTar = tipoTar;
    }

    public String getExpiracionTarj() {
        return expiracionTarj;
    }

    public void setExpiracionTarj(String expiracionTarj) {
        this.expiracionTarj = expiracionTarj;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPago != null ? idPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.idPago == null && other.idPago != null) || (this.idPago != null && !this.idPago.equals(other.idPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arquisocios.entity.Pago[ idPago=" + idPago + " ]";
    }
    
}
