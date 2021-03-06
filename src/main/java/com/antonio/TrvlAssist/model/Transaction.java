package com.antonio.TrvlAssist.model;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    @Builder.Default
    @Column(columnDefinition = "DATETIME")
    private final LocalDateTime date = LocalDateTime.now();






    public String getOnlyDate() {

        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getFormattedDateTime() {

        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
    }

    public void setProduct(Product product) {

        Product oldProduct = this.product;

        if (Objects.equals(product, oldProduct))
            return;

        this.product = product;

        if (oldProduct!=null)
            oldProduct.removeTransaction(null);

        if (product!=null)
            product.addTransaction(this);
    }

    public void setUser(User user) {

        User oldUser = this.user;

        if (Objects.equals(user, oldUser))
            return;

        this.user = user;

        if (oldUser!=null)
            oldUser.removeTransaction(null);

        if (user!=null)
            user.addTransaction(this);
    }



    @Override
    public String toString() {

        return "Stock " + id + ": [product = " + product.getName() + ", price = " + product.getPrice() +
                ", user = " + user.getName() + ", date = " + date + "]";
    }

}
