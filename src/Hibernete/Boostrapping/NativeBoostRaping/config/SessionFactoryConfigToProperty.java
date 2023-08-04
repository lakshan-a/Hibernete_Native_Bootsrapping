package Hibernete.Boostrapping.NativeBoostRaping.config;

import Hibernete.Boostrapping.NativeBoostRaping.entity.Customer;
import Hibernete.Boostrapping.NativeBoostRaping.entity.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class SessionFactoryConfigToProperty {
    private static SessionFactory factory;
    private static SessionFactoryConfigToProperty configToProperty;

    private SessionFactoryConfigToProperty(){
        Configuration configuration = new Configuration();
        Properties properties = new Properties();

        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("Hibenete/Boostrapping/NativeBoostRaping/hibernate.Properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        configuration.addAnnotatedClass(Customer.class).addAnnotatedClass(Item.class);
        factory=configuration.setProperties(properties).buildSessionFactory();
    }

    public static SessionFactoryConfigToProperty getInstance(){
        return configToProperty == null ? new SessionFactoryConfigToProperty() : configToProperty;
    }

    public Session getSession(){
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
