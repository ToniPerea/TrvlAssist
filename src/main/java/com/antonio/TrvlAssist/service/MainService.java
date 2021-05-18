package  com.antonio.TrvlAssist.service;




import com.antonio.TrvlAssist.model.Product;
import com.antonio.TrvlAssist.model.Purchase;
import com.antonio.TrvlAssist.model.Transaction;
import  com.antonio.TrvlAssist.model.User;

import com.antonio.TrvlAssist.repository.ProductRepository;
import com.antonio.TrvlAssist.repository.PurchaseRepository;
import com.antonio.TrvlAssist.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.unit.DataSize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MainService {

    private final TransactionRepository transactionRepository;
    private final ProductRepository productRepository;
    private final PurchaseRepository purchaseRepository;

    public List<Transaction> listAllTransactions() {

        return transactionRepository.findAll();
    }

    public Transaction getTransactionByID(Long id) {

        return transactionRepository.getById(id);
    }

    public void saveTransaction(Transaction transaction) {

        transactionRepository.save(transaction);
    }

    public void saveProduct(Product p){
        productRepository.save(p);
    }



    public List<Product> listAllProducts() {

        return productRepository.findAll();
    }

    public Product getProductByID(Long id) {

        return productRepository.getById(id);
    }


    public void purchaseInsurance(Long idProduct, User user){
        Transaction t = new Transaction();
        t.setUser(user);
        t.setProduct(productRepository.getById(idProduct));
        transactionRepository.save(t);
        Product p = productRepository.getById(idProduct);
        p.removeQuantity(1);

        productRepository.save(p);
        System.out.println("[mainService] purchaseInsurance" + t.toString());
    }


    public List<Transaction> getShoppingCart(User u){
        System.out.println("[mainService][getShoppingCart]");
         return Arrays.asList(transactionRepository.findAll().stream().filter(s -> s.getUser().getId() == u.getId()).toArray(Transaction[]::new));
    }

    public void eraseProductFromShoppingCart(Long id){
        System.out.println("[mainService][eraseProductFromShoppingCart]");
        //transactionRepository.deleteProductsShoppingCart(id);
        transactionRepository.deleteById(id);
    }

    public void delete(Long id){
        System.out.println("[mainService][removeProductFromDatabase]");
        productRepository.deleteById(id);
    }


    // Tengo que meter los productos del carrito en la tabla purchase
    public void addShoppingCartToOrdersConfirmation(List<Transaction> miCarrito, User s){
        Purchase p = new Purchase();
        p.setUser(s);
        for(Transaction t : miCarrito) {
            System.out.println("Veo parcialmente en el carrito: " + t.getProduct().toString());
            p.addProduct(t.getProduct());
        }
        purchaseRepository.save(p);
    }

    public void removeAllShoppingCartForUser(List<Transaction> miCarrito, User s){
        transactionRepository.deleteAll(miCarrito);
    }


    public void removeProductFromDB(Long id){
        //ProductRepository pr = productRepository.findById()
    }


    
}