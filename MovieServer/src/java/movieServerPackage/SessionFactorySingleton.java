/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieServerPackage;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author panda
 */
public class SessionFactorySingleton {
    private static SessionFactory session;
    private static final SessionFactorySingleton instance = new SessionFactorySingleton();

    public SessionFactorySingleton() {
        Configuration  con = new Configuration();
        con.configure();
        ServiceRegistry service = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        session = con.buildSessionFactory(service);
    }

    public static SessionFactory getSession() {
        return session;
    }
    
}
