package ru.novotelecom.java_training.mantis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.novotelecom.java_training.mantis.model.UserData;
import ru.novotelecom.java_training.mantis.model.Users;

import java.util.List;

public class DbHelper {
    private ApplicationManager app;
    private final SessionFactory sessionFactory;

    public DbHelper(ApplicationManager app) {
        this.app = app;
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();

    }

 public Users users () {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<UserData> result = session.createQuery( "from UserData where not id =1" ).list();
       // List<UserData> result = session.createQuery("from UserData where not username = 'administrator'").list();
        for ( UserData user : result ) {
            System.out.println( user);
        }
        session.getTransaction().commit();
        session.close();
        return new Users(result);
    }




}
