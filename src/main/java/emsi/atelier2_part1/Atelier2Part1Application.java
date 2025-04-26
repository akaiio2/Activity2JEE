package emsi.atelier2_part1;

import emsi.atelier2_part1.entities.Product;
import emsi.atelier2_part1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@SpringBootApplication
public class Atelier2Part1Application implements CommandLineRunner {
@Autowired //pour l'injection des deps cad demande a spring inject moi dans l'obj productRepo un obj de type ^productRepo
private ProductRepository productRepository;
    public static void main(String[] args) {
        //si je demarre cette app l 1ere qui va demarr c spring et quaund spring deùar il va config JPA class annot...

        SpringApplication.run(Atelier2Part1Application.class, args);
    }
    @Override
    //une fois spring demarr il fait appel a la methode run
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null,"Computer",4300,3));
        productRepository.save(new Product(null,"Computer2",4350,6));
        productRepository.save(new Product(null,"Computer3",4380,9));
        List<Product>products=productRepository.findAll();// il ma return une liste de produit
        products.forEach(
                p->{System.out.println(p.toString());}
        );
        Product product=productRepository.findById(Long.valueOf(1)).get();
        System.out.println("---------------");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQuantity());
        System.out.println("---------------");

List<Product> productList= productRepository.findByNameContains("C");
productList.forEach(p->{
    System.out.println(p);

});

System.out.println("----------------");
        List<Product> productList2= productRepository.search("%C%");
        productList.forEach(p->{
            System.out.println(p);

        });
        System.out.println("--------********--------");
        List<Product> productList3= productRepository.findByPriceGreaterThan(3000);
        productList.forEach(p->{
            System.out.println(p);

        });
        System.out.println("--------********--------");
        List<Product> productList4= productRepository.searchByPrice(3000);
        productList.forEach(p->{
            System.out.println(p);

        });
    }


}
