package Hibernete.Boostrapping.NativeBoostRaping.controller;

import Hibernete.Boostrapping.NativeBoostRaping.config.SessionFactoryConfig;
import Hibernete.Boostrapping.NativeBoostRaping.entity.Customer;
import Hibernete.Boostrapping.NativeBoostRaping.entity.Item;
import Hibernete.Boostrapping.NativeBoostRaping.repository.CustomerRepository;
import Hibernete.Boostrapping.NativeBoostRaping.repository.ItemRepository;
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

public class ItemController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colCode;

    @FXML
    private TableColumn<?, ?> colDes;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private ImageView imgHome;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<?> tblItems;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtItemDes;

    @FXML
    private TextField txtItemUnit;

    @FXML
    private TextField txtQty;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Session session= SessionFactoryConfig.getInstance().getSession();
        Transaction trans = session.beginTransaction();

        String id = (txtItemCode.getText());
        Item item = session.get(Item.class,id);

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        Item item = new Item(txtItemCode.getText(),txtItemDes.getText(),Integer.parseInt(txtItemUnit.getText()),Integer.parseInt(txtQty.getText()));
        ItemRepository itemRepository = new ItemRepository();
        String savedItemCode = itemRepository.saveItem(item);
        System.out.println("Saved Item Id: " + savedItemCode);

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        ItemRepository itemRepository = new ItemRepository();

        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Customer item = itemRepository.getItem(txtItemCode.getText());

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Item iteam = session.get(Item.class, Integer.parseInt(txtItemCode.getText()));

        iteam.setDescription(txtItemDes.getText());
        iteam.setItemCode(txtItemCode.getText());
        iteam.setPrice(Double.parseDouble(txtItemUnit.getText()));
        iteam.setQty(Integer.parseInt(txtQty.getText()));

        session.update(iteam);
        transaction.commit();
        session.close();

    }

    public void btnBack(MouseEvent mouseEvent) throws IOException {
        URL resource = this.getClass().getResource("/Hibernete/Boostrapping/NativeBoostRaping/view/Home.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());

    }
}
