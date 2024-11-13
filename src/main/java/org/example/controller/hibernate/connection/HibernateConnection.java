package org.example.controller.hibernate.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

 public class HibernateConnection {
    private static SessionFactory sessionFactory = null; // Should be of type SessionFactory

    // Private constructor to prevent instantiation
    private HibernateConnection() {
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // Configure the Hibernate settings from the hibernate.cfg.xml file
            try {
                // This will look for hibernate.cfg.xml in the classpath (e.g., src/main/resources)
                final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                        .configure() // Automatically looks for hibernate.cfg.xml in the classpath
                        .build();

                // Build the SessionFactory from the service registry
                sessionFactory = new MetadataSources(registry)
                        .buildMetadata()
                        .buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace(); // Handle exceptions as needed
                throw new ExceptionInInitializerError("Initial SessionFactory creation failed: " + e);
            }
        }
        return sessionFactory;
    }

    public static Session openSession() {
        return getSessionFactory().openSession(); // Use openSession() method
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close(); // Close the SessionFactory when done
            sessionFactory = null; // Reset the static variable
        }
    }
}
