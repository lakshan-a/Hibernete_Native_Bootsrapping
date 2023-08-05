package Hibernete.Boostrapping.NativeBoostRaping;


import Hibernete.Boostrapping.NativeBoostRaping.config.SessionFactoryConfig;
import Hibernete.Boostrapping.NativeBoostRaping.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Appinitilazer {
    public static void main(String[] args) {
        // save
        Session session =  SessionFactoryConfig.getInstance().getSession();

        Customer customer = new Customer();
        customer.setId(2);
        customer.setName("kalshan");
        customer.setAddress("galle");
        customer.setSalary(10000.00);


        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();



    }
}
