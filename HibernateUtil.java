package com.hospitalmanagementsystem;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//Utility class for managing the Hibernate SessionFactory.
public class HibernateUtil {
	// Singleton instance of the SessionFactory
    private static final SessionFactory sessionFactory = buildSessionFactory();
 // Build the SessionFactory from the hibernate.cfg.xml file
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure("connection.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    // Get the singleton instance of the SessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
