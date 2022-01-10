/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.OurMentalUtil;
import pojo.TblRegistrasi;

/**
 *
 * @author titacahyaa
 */
public class DAORegistrasi {
    public List<TblRegistrasi> getBy(String nRegistrasi, String uEmail, String nTelp,String jKelamin)
    {
        Transaction trans = null;
        TblRegistrasi us = new TblRegistrasi();
        List<TblRegistrasi> registrasi = new ArrayList();
        Session session = OurMentalUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblRegistrasi where namaLengkap = nRegistrasi, emailUser = uEmail, noTelp = nTelp, jenisKelamin = jKelamin");
            query.setString("nRegistrasi", nRegistrasi);
            query.setString("uEmail", uEmail);
            query.setString("nTelp", nTelp);
            query.setString("jKelamin", jKelamin);
            us = (TblRegistrasi) query.uniqueResult();
            registrasi = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);   
        }
        return registrasi;
    }
    
public void add_registrasi(TblRegistrasi registrasi)
    {
        Transaction trans = null;
        Session session = OurMentalUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(registrasi);
            trans.commit();
            
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
 