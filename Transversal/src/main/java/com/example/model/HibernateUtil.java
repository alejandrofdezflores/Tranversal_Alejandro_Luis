package com.example.model;
// Generated 12-mar-2019 14:12:29 by Hibernate Tools 4.3.1
import java.util.Properties;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.SessionFactory;

/**
 * @author Luis
 * @version 1.0
 * @since 02/02/2019
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(AvailableSettings.DRIVER, "com.mysql.jdbc.Driver");

				settings.put(AvailableSettings.URL, "jdbc:mysql://localhost:3306/transversal?useSSL=false&serverTimezone=UTC");
				settings.put(AvailableSettings.USER, "admin");
				settings.put(AvailableSettings.PASS, "admin");
				settings.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

				settings.put(AvailableSettings.SHOW_SQL, "true");

				settings.put(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				//settings.put(Environment.HBM2DDL_AUTO, "create-drop");

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Alumno.class);
                configuration.addAnnotatedClass(Asignatura.class);
                configuration.addAnnotatedClass(Profesor.class);
                configuration.addAnnotatedClass(Clase.class);


				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate Java Config serviceRegistry created");
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				return sessionFactory;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
}
}