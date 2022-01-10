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
import pojo.TblAdmin;

/**
 *
 * @author Lenovo
 */
public class DAOLogin {
    public List<TblAdmin> getBy(String uName, String uPass)
    {
        Transaction trans = null;
        TblAdmin ad = new TblAdmin();
        List<TblAdmin> admin = new ArrayList();
        Session session = OurMentalUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblAdmin where username=:uName AND password=:uPass");
            query.setString("uName", uName);
            query.setString("uPass", uPass);
            ad = (TblAdmin) query.uniqueResult();
            admin = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return admin;
    }
    public void add_admin(TblAdmin admin)
    {
        Transaction trans = null;
        Session session = OurMentalUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(admin);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e); 
        }
    }
}
