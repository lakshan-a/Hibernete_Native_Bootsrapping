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
        customer.setId(3);
        customer.setName("lakshan");
        customer.setAddress("panadura");
        customer.setSalary(10000.00);


        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();

        //update
//        Session session1 = SessionFactoryConfig.getInstance().getSession();
//        Transaction transaction1 = session1.beginTransaction();
//         Customer customer = session1.get(Customer.class,1);
//                 customer.setAddress("Matara");
//                 customer.setName("Rashmiks");
//                 session1.update(customer);
//                 transaction1.commit();
//                 session1.close();
//
//         Session session2 = SessionFactoryConfig.getInstance().getSession();
//         Transaction transaction = session2.beginTransaction();
//         Customer customer1 = session2.get(Customer.class,1);
//         session2.delete(customer1);
//         transaction.commit();
//         session2.close();

        //3. delete

//        Session deleteSession = SessionFactoryConfig.getInstance().getSession();
//        Transaction deleteTransaction = deleteSession.beginTransaction();
//        Customer deleteCustomer = deleteSession.get(Customer.class,1);
//        deleteSession.delete(deleteCustomer);
//        deleteTransaction.commit();
//        deleteSession.close();



    }
}
