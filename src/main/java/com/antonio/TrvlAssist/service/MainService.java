package  com.antonio.TrvlAssist.service;




import  com.antonio.TrvlAssist.model.User;

     
  
      
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

    

    
}