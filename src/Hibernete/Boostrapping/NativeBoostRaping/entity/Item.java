package Hibernete.Boostrapping.NativeBoostRaping.entity;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @Column(name = "ItemCode" ,length = 30)
    private String itemCode;
    @Column(name = "Description")
    private String description;
    @Column(name = "Price")
    private double price;
    @Column(name = "Qty")
    private int qty;

    public Item() {
    }

    public Item(String itemCode, String description, double price, int qty) {

        this.itemCode = itemCode;
        this.description = description;
        this.price = price;
        this.qty = qty;
    }


    public String getItemCode() {
        return itemCode;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemCode='" + itemCode + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }
}
