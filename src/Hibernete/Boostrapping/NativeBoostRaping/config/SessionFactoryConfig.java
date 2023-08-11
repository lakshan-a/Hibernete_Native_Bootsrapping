package Hibernete.Boostrapping.NativeBoostRaping.config;

import Hibernete.Boostrapping.NativeBoostRaping.entity.Customer;
import Hibernete.Boostrapping.NativeBoostRaping.entity.Customer;
import Hibernete.Boostrapping.NativeBoostRaping.entity.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class SessionFactoryConfig {

    private static SessionFactory factory;
    private static SessionFactoryConfig configToProperty;

    private SessionFactoryConfig(){
        Configuration configuration = new Configuration();
        Properties properties = new Properties();

        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.Properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        configuration.addAnnotatedClass(Customer.class).addAnnotatedClass(Item.class);
        factory=configuration.setProperties(properties).buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance(){
        return configToProperty == null ? new SessionFactoryConfig() : configToProperty;
    }

    public Session getSession() {
       /* Properties properties = null;
        if (properties == null) {
            properties = new Properties();
            try {
                properties.load(Customer.class
                        .getResourceAsStream("hibernate.Properties"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
        return factory.openSession();
    }
}
