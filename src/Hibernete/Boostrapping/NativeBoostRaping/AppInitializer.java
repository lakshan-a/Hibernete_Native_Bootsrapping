package Hibernete.Boostrapping.NativeBoostRaping;


import Hibernete.Boostrapping.NativeBoostRaping.embedded.MobileNo;
import Hibernete.Boostrapping.NativeBoostRaping.embedded.NameIdentifier;
import Hibernete.Boostrapping.NativeBoostRaping.entity.Customer;
import Hibernete.Boostrapping.NativeBoostRaping.repository.CustomerRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.transaction.Transaction;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javafx.application.Application.launch;

//public class AppInitializer extends Application  {
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) throws IOException {
//        Parent root = FXMLLoader.load(this.getClass().getResource("/Hibernete/Boostrapping/NativeBoostRaping/view/Home.fxml"));
//        Scene mainScene = new Scene(root);
//        primaryStage.setScene(mainScene);
//        primaryStage.setTitle("Java FX POS");
//        primaryStage.centerOnScreen();
//        primaryStage.show();
//    }
//}

public class AppInitializer {


    public static void main(String[] args) {
        Customer customer = getCustomer();

        // 1. Save
        CustomerRepository cusRepository = new CustomerRepository();
        int savedCusId = cusRepository.saveCustomer(customer);
        System.out.println("Saved Cus Id: " + savedCusId);

        // 2. Get
        cusRepository = new CustomerRepository();
        Customer existingCustomer = cusRepository.getCustomer(savedCusId);
        System.out.println(existingCustomer);

//        // 3. Update
//        cusRepository = new CustomerRepository();
//        existingCustomer.setAddress("Matara");
//        boolean isUpdated = cusRepository.updateCustomer(existingCustomer);
//        if (isUpdated) {
//            System.out.println("Customer Updated!");
//        } else {
//            System.out.println("Customer Update Failed!");
//        }
//
//        // 4. Delete
//        cusRepository = new CustomerRepository();
//        boolean isDeleted = cusRepository.deleteCustomer(existingCustomer);
//        if (isDeleted) {
//            System.out.println("Customer Deleted!");
//        } else {
//            System.out.println("Customer Deletion Failed!");
//        }
    }

    private static Customer getCustomer() {
        Customer customer = new Customer();
        customer.setId(1);
        NameIdentifier nameIdentifier = getNameIdentifier();
        customer.setNameIdentifier(nameIdentifier);
        customer.setAddress("Galle");
        customer.setSalary(25000.00);

        List<MobileNo> mobileNos = getMobileNos();
        customer.setPhoneNos(mobileNos);
        return customer;
    }

    private static List<MobileNo> getMobileNos() {
        List<MobileNo> mobileNos = new ArrayList<>();
        MobileNo homeNo = new MobileNo();
        homeNo.setType("HOME");
        homeNo.setMobileNo("0913456767");
        mobileNos.add(homeNo);

        MobileNo mobileNo = new MobileNo();
        mobileNo.setType("MOBILE");
        mobileNo.setMobileNo("0713456767");
        mobileNos.add(mobileNo);
        return mobileNos;
    }

    private static NameIdentifier getNameIdentifier() {
        NameIdentifier nameIdentifier = new NameIdentifier();
        nameIdentifier.setFirstName("Saman");
        nameIdentifier.setMiddleName("Perera");
        nameIdentifier.setLastName("De Silva");
        return nameIdentifier;
    }
}
