package Hibernete.Boostrapping.NativeBoostRaping.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {


    @Id
    @Column(name = "customer_id")
    private int id;

    @Column(name = "csutomer_name")
    private String name;

    @Column(name = "customer_address")
    private String Address;

    @Column(name = "customer_salary")
    private double salary;
}
