package Hibernete.Boostrapping.NativeBoostRaping.controller;

import Hibernete.Boostrapping.NativeBoostRaping.config.SessionFactoryConfig;
import Hibernete.Boostrapping.NativeBoostRaping.entity.Customer;
import Hibernete.Boostrapping.NativeBoostRaping.repository.CustomerRepository;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.net.URL;

public class CustomerController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colAd;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TextField cstAd;

    @FXML
    private TextField cstId;

    @FXML
    private TextField cstName;

    @FXML
    private TableView<?> cstTbl;

    @FXML
    private ImageView imgBack;

    @FXML
    private AnchorPane root;

    @FXML
    void btnBack(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/Hibernete/Boostrapping/NativeBoostRaping/view/Home.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Session session= SessionFactoryConfig.getInstance().getSession();
        Transaction trans = session.beginTransaction();

        String id = (cstId.getText());
        Customer customer = session.get(Customer.class,id);

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        Customer customer = new Customer(cstId.getText(),cstName.getText(),cstAd.getText());
        CustomerRepository cusRepository = new CustomerRepository();
        String savedCusId = cusRepository.saveCustomer(customer);
        System.out.println("Saved Cus Id: " + savedCusId);

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        CustomerRepository customerRepository = new CustomerRepository();

        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = customerRepository.getCustomer(cstId.getText());

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

}
