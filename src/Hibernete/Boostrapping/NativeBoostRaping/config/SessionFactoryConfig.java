package Hibernete.Boostrapping.NativeBoostRaping.config;

import Hibernete.Boostrapping.NativeBoostRaping.entity.Customer;
import Hibernete.Boostrapping.NativeBoostRaping.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.IOException;
import java.util.Properties;

public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;

    SessionFactory sessionFactory;


    private SessionFactoryConfig(){
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.Properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        StandardServiceRegistry serviceRegistry;

        Metadata metadata= new MetadataSources(new StandardServiceRegistryBuilder()
                .applySettings(properties)
                .build())
                .addAnnotatedClass(Customer.class)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build();

       // SessionFactory sessionFactory = metadata.buildSessionFactory();

        sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder()
                .configure()
                .build())
                . addAnnotatedClass(Customer.class)
                .getMetadataBuilder()
                .build().buildSessionFactory();

    }

    public static SessionFactoryConfig getInstance(){
        return (null==factoryConfig) ? factoryConfig=new SessionFactoryConfig() : factoryConfig;
    }

    public Session getSession(){


        return sessionFactory.openSession();
    }
}
