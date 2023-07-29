package Hibernete.Boostrapping.NativeBoostRaping;


import Hibernete.Boostrapping.NativeBoostRaping.config.SessionFactoryConfig;
import Hibernete.Boostrapping.NativeBoostRaping.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App_Initilazer {
    public static void main(String[] args) {
        Session session = SessionFactoryConfig.getInstance().getSession();

        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Lakshan");
        customer.setAddress("Matara");
        customer.setSalary(20000.00);

        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();

    }
}
