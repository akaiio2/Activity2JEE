package emsi.atelier2_part1.web;

import emsi.atelier2_part1.entities.Product;
import emsi.atelier2_part1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductRestService {
    @Autowired
    private ProductRepository productRepository;
    //donne la liste des produites en forma json
@GetMapping("/products")
    public List<Product> products(){
        return productRepository.findAll();
    }
    @GetMapping("/products/{id}")
 public Product findProduct(@PathVariable Long id){
        //Optional<Product> byId =productRepository.findById(id);
        //return byId.get();
        Product product =productRepository.findById(id).orElse(null);
        return product;
    }


}
