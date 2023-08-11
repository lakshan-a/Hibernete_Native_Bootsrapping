package Hibernete.Boostrapping.NativeBoostRaping.repository;

import Hibernete.Boostrapping.NativeBoostRaping.config.SessionFactoryConfig;
import Hibernete.Boostrapping.NativeBoostRaping.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerRepository {

    private Session session;
    public CustomerRepository(){
        session = SessionFactoryConfig
                .getInstance()
                .getSession();
    }
    public Customer getCustomer(String id){
        try {
            return session.get(Customer.class,id);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public String saveCustomer(Customer customer){
//        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            String id =(String) session.save(customer);
            transaction.commit();
            session.close();
            return id;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return "false";
        }
    }
    public boolean updateCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();
        try {
            session.update(customer);
            return true;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }

    }

    public boolean deleteCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();
        try{
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
