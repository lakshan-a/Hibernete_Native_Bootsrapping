package Hibernete.Boostrapping.NativeBoostRaping.repository;

import Hibernete.Boostrapping.NativeBoostRaping.config.SessionFactoryConfig;
import Hibernete.Boostrapping.NativeBoostRaping.entity.Customer;
import org.hibernate.Session;

public class CustomerRepository {

    private final Session session;

    public CustomerRepository(){
       session = SessionFactoryConfig.getInstance().getSession();
    }

    public Customer getCustomer(int id){
        return session.get(Customer.class,1);
    }
}
