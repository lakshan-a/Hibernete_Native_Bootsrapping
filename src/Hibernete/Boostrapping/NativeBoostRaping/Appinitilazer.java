package Hibernete.Boostrapping.NativeBoostRaping;


import Hibernete.Boostrapping.NativeBoostRaping.config.SessionFactoryConfig;
import Hibernete.Boostrapping.NativeBoostRaping.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Appinitilazer {
    public static void main(String[] args) {

        Session session = SessionFactoryConfig.getInstance().getSession();
        Customer customer = new Customer();
        customer.setId(5);
        customer.setName("Kamal");
        customer.setAddress("Galle");
        customer.setSalary(25000.00);

        //1. save krnne meken

        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();

    }
}
