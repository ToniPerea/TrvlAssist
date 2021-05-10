package  com.antonio.TrvlAssist.service;




import com.antonio.TrvlAssist.model.Product;
import com.antonio.TrvlAssist.model.Transaction;
import  com.antonio.TrvlAssist.model.User;

import com.antonio.TrvlAssist.repository.ProductRepository;
import com.antonio.TrvlAssist.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.unit.DataSize;

import java.io.IOException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MainService {

    @Value("${spring.servlet.multipart.max-file-size}")
    private DataSize maxUploadSize;


    private final TransactionRepository transactionRepository;
    private final ProductRepository productRepository;

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






    
}