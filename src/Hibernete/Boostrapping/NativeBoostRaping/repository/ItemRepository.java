package Hibernete.Boostrapping.NativeBoostRaping.repository;

import Hibernete.Boostrapping.NativeBoostRaping.config.SessionFactoryConfig;
import Hibernete.Boostrapping.NativeBoostRaping.entity.Customer;
import Hibernete.Boostrapping.NativeBoostRaping.entity.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ItemRepository {

    private Session session;

    public ItemRepository(){
        session = SessionFactoryConfig
                .getInstance()
                .getSession();
    }
    public Customer getItem(String id){
        try {
            return session.get(Customer.class,id);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public String saveItem(Item item){
//        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            String code =(String) session.save(item);
            transaction.commit();
            session.close();
            return code;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return "false";
        }
    }
    public boolean updateItem(Item item){
        Transaction transaction = session.beginTransaction();
        try {
            session.update(item);
            return true;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }

    }

    public boolean deleteItem(Item item){
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(item);
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
