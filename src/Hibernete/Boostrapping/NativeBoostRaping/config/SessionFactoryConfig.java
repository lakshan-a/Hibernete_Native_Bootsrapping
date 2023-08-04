package Hibernete.Boostrapping.NativeBoostRaping.config;

import Hibernete.Boostrapping.NativeBoostRaping.entity.Customer;
import Hibernete.Boostrapping.NativeBoostRaping.entity.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryConfig {

    public static SessionFactoryConfig configuration;

    private SessionFactoryConfig(){}

    public static SessionFactoryConfig getInstance(){
        return configuration == null ? new SessionFactoryConfig() : configuration;
    }

    public Session getSession(){

        StandardServiceRegistry builder = new StandardServiceRegistryBuilder().configure("Hibenete/Boostrapping/NativeBoostRaping/hibernate.Properties").build();
        Metadata meta = new MetadataSources(builder).addAnnotatedClass(Customer.class).addAnnotatedClass(Item.class).
                getMetadataBuilder().
                applyImplicitNamingStrategy(ImplicitNamingStrategyComponentPathImpl.INSTANCE).
                build();


        SessionFactory sessionFactory = meta.buildSessionFactory();
        return sessionFactory.openSession();
    }
}
