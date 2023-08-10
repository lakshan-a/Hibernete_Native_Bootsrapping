package Hibernete.Boostrapping.NativeBoostRaping.entity;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_code", nullable = false, length = 50)
    private int Code;

    @Column(name = "item_description")
    private String Description;

    @Column(name = "item_price")
    private double Price;

    @Column(name = "qty_on_hand")
    private int QTY;


    public Item(int code, String description, double price, int QTY) {
        Code = code;
        Description = description;
        Price = price;
        this.QTY = QTY;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getQTY() {
        return QTY;
    }

    public void setQTY(int QTY) {
        this.QTY = QTY;
    }

    @Override
    public String toString() {
        return "Item{" +
                "Code=" + Code +
                ", Description='" + Description + '\'' +
                ", Price=" + Price +
                ", QTY=" + QTY +
                '}';
    }
}
