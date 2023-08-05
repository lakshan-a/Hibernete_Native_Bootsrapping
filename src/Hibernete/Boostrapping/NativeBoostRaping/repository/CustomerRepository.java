package Hibernete.Boostrapping.NativeBoostRaping.repository;

import Hibernete.Boostrapping.NativeBoostRaping.config.SessionFactoryConfig;
import Hibernete.Boostrapping.NativeBoostRaping.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerRepository {

    private final Session session;

    public CustomerRepository(){
       session = SessionFactoryConfig.getInstance().getSession();
    }

    public int saveCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();

        int customerId = (int) session.save(customer);
        transaction.commit();
        session.close();
        return customerId;
    }

    public Customer getCustomer(int id){
        return session.get(Customer.class,id);
    }

    public boolean updateCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();

        session.update(customer);
        transaction.commit();
        session.close();
        return true;
    }

    public boolean deleteCustomer(Customer customer){
        Transaction transaction =session.beginTransaction();

        session.delete(customer);
        transaction.commit();
        session.close();
        return true;
    }

}
