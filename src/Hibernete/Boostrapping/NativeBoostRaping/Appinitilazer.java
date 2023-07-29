package Hibernete.Boostrapping.NativeBoostRaping;


import Hibernete.Boostrapping.NativeBoostRaping.config.SessionFactoryConfig;
import Hibernete.Boostrapping.NativeBoostRaping.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Appinitilazer {
    public static void main(String[] args) {


        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Lakshan");
        customer.setAddress("Matara");
        customer.setSalary(20000.00);

//        Session session = SessionFactoryConfig
//                .getInstance()
//                .getSession();
//
//        Transaction transaction = session.beginTransaction();
//        session.save(customer);
//        transaction.commit();
//        session.close();

        Session session1 = SessionFactoryConfig
                .getInstance()
                .getSession();

        Transaction transaction1 = session1.beginTransaction();

        Customer customer1 = session1.get(Customer.class,1);
        customer1.setAddress("Gella");
        customer1.setName("Rashmika");
        //session1.save(customer1);
        session1.update(customer1);

        transaction1.commit();
        session1.close();



        Session session2 = SessionFactoryConfig
                .getInstance()
                .getSession();

        Transaction  deletetransaction = session2.beginTransaction();

        Customer customer2 = session2.get(Customer.class,1);
        session2.delete(customer2);

        deletetransaction.commit();
        session2.close();

    }
}
