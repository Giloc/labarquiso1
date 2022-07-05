/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagos.session;

import com.pagos.entity.Pago;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author User
 */
@Stateless
public class PagoManager implements PagoManagerLocal {

    @PersistenceContext(unitName = "com.pagos_PasarelaPagosLAB2-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Pago> getAllPagos() {
        Query query=em.createNamedQuery("Pago.findAll");
        return query.getResultList();
    }

    @Override
    public void saveDatabase(Pago pago) {
        em.createNativeQuery("INSERT INTO pago (id_cliente, nom_cliente,apell_cliente,email_cliente,num_tar,"+
          "csv_tar, tipo_tar, expiracion_tarj, valor_pago, fecha_pago) VALUES (?,?,?,?,?,?,?,?,?,?)")
      .setParameter(1,pago.getIdCliente())
      .setParameter(2,pago.getNomCliente())
      .setParameter(3,pago.getApellCliente())
      .setParameter(4,pago.getEmailCliente())
      .setParameter(5,pago.getNumTar())
      .setParameter(6,pago.getCsvTar())
      .setParameter(7,pago.getTipoTar())
      .setParameter(8,pago.getExpiracionTarj())
      .setParameter(9,pago.getValorPago())
      .setParameter(10,pago.getFechaPago())
      .executeUpdate();;
    }
    
}
