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

        try {
            int customerId = (int) session.save(customer);
            transaction.commit();
            session.close();
            return customerId;
        }catch (Exception  e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return -1;
        }

    }

    public Customer getCustomer(int id){
        try {
            return session.get(Customer.class,id);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }

    public boolean updateCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();

        try {
            session.update(customer);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }


    }

    public boolean deleteCustomer(Customer customer){
        Transaction transaction =session.beginTransaction();

        try {
            session.delete(customer);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }

    }

}
