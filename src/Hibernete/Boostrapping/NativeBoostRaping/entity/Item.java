package Hibernete.Boostrapping.NativeBoostRaping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "item")
public class Item {
    @Id
    @Column(name = "code")
    private String itemCode;
    @Column(name = "ItemName")
    private String name;
    @Column(name = "ItemPrice")
    private Double price;
    @Column(name = "ItemQty")
    private Integer qty;
}
