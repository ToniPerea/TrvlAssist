package com.antonio.TrvlAssist.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

//import static com.pierre.oceanblu.model.Transaction.*;

@Entity
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Collection<Transaction> transactions;

    private String name;
    private Float price;
    private String description;

    private Integer quantity;

    private String image;




    public Product() {
        this.name="";
        this.description="";
        this.price=new Float(0);
        this.quantity = 0;
        this.image = "";
    }

    public Long getId() {

        return id;
    }

    public Collection<Transaction> getTransactions() {

        return new ArrayList<>(transactions);
    }

    public String getName() {

        return name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Float getPrice() {

        return price;
    }

    public Integer getQuantity() {

        return quantity;
    }



    public String getDescription() {

        return description;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }



    public void setDescription(String description) {
        this.description = description;
    }

    public void addTransaction(Transaction transaction) {

        if (transactions.contains(transaction))
            return;

        transactions.add(transaction);
        transaction.setProduct(this);
    }

    public void removeTransaction(Transaction transaction) {

        if (!transactions.contains(transaction))
            return;

        transactions.remove(transaction);
        transaction.setProduct(null);
    }

    public void addQuantity(Integer quantity) {

        this.quantity += quantity;
    }

    public void removeQuantity(Integer quantity) {

        this.quantity -= quantity;
    }




    @Override
    public String toString() {
        return id + "," + name + "," + price + "," +  quantity + "," + description;
    }
}