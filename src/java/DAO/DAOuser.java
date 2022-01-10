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
 * @author Lenovo
 */
public class DAOuser {
    public List<TblRegistrasi> retrieveTblRegistrasi(Transaction trans)
    {List stud = new ArrayList();
    TblRegistrasi stud1 = new TblRegistrasi();
    Session session = OurMentalUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblRegistrasi");
            stud = query.list();
            stud.add(stud1.getIdUser());
            stud.add(stud1.getNamaLengkap());
            stud.add(stud1.getEmailUser());
            stud.add(stud1.getNoTelp());
            stud.add(stud1.getJenisKelamin());
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return stud;
    }
    public List<TblRegistrasi> getbyID(String idU){
        TblRegistrasi reg = new TblRegistrasi();
        List <TblRegistrasi> iReg = new ArrayList();
        
        Transaction trans = null;
        Session session = OurMentalUtil.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblRegistrasi where id_user = id");
            query.setString("id", idU);
            reg = (TblRegistrasi) query.uniqueResult();
            iReg = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return iReg;
    }
    public void deleteUser(String idU)
    {
        Transaction trans = null;
        Session session = OurMentalUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            TblRegistrasi reg = (TblRegistrasi) session.load(TblRegistrasi.class, new String(idU));
            session.delete(reg);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            
        }
    }
    public void editUser(TblRegistrasi reg)
    {
        Transaction trans = null;
        Session session = OurMentalUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(reg);
            trans.commit();            
        } catch (Exception e) {
            System.out.println(e);
        }
    }    
}
