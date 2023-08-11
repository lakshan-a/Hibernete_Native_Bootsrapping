package Hibernete.Boostrapping.NativeBoostRaping.config;

import Hibernete.Boostrapping.NativeBoostRaping.entity.Customer;
import Hibernete.Boostrapping.NativeBoostRaping.entity.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class Config {

    public static Config config;

    private Config(){}

    public static Config getInstance(){
        return config == null ? new Config() : config;
    }

    public Session getSession(){

        StandardServiceRegistry builder = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(builder).addAnnotatedClass(Customer.class).addAnnotatedClass(Item.class).
                getMetadataBuilder().
                applyImplicitNamingStrategy(ImplicitNamingStrategyComponentPathImpl.INSTANCE).
                build();


        SessionFactory sessionFactory = meta.buildSessionFactory();
        return sessionFactory.openSession();
    }

}
