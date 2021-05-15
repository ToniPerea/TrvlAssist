package com.antonio.TrvlAssist.model;


import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition="TEXT")
    @Lob
    private String products = "";




    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    @Builder.Default
    @Column(columnDefinition = "DATETIME")
    private final LocalDateTime date = LocalDateTime.now();

    public void addProduct(Product p){

        String aux = new StringBuilder()
                .append(products)
                .append("\n")
                .append(p.toString())
                .toString();
        products = aux;
    }


    public String getOnlyDate() {

        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getFormattedDateTime() {

        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
    }

    /*public void setTransaction(Transaction transaction) {

        Transaction oldProduct = this.transaction;

    }*/



    @Override
    public String toString() {

        return "Stock " + id + ": [transaction = "  +
                ", user = " + user.getName() + ", date = " + date + "]";
    }

}

