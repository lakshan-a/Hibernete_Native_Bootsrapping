package Hibernete.Boostrapping.NativeBoostRaping.controller;

import Hibernete.Boostrapping.NativeBoostRaping.entity.Customer;
import Hibernete.Boostrapping.NativeBoostRaping.repository.CustomerRepository;
import com.sun.deploy.config.Config;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerController {
    @FXML
    private Button upBtn;
    @FXML
    private Button dltBtn;
    @FXML
    private TextField adTxt;


    @FXML
    private Button scBtn;
    @FXML
    private TextField idTxt;

    @FXML
    private TextField nmTxt;

    @FXML
    private TextField salTxt;

    @FXML
    void svBtnOnAction(ActionEvent event) {

    }
    @FXML
    void scBtnOnAction(ActionEvent event) {



    }


    @FXML
    void upBtnOnAction(ActionEvent event) {



    }
    @FXML
    void dltBtnOnAction(ActionEvent event) {


    }
}
