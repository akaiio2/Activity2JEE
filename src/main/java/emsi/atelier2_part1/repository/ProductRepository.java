package emsi.atelier2_part1.repository;

import emsi.atelier2_part1.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByNameContains(String mc);
    List<Product> findByPriceGreaterThan(double price);

    // Cette annotation permet de définir une requête JPQL personnalisée
    @Query("select p from Product p where p.name like :x")

// Cette méthode retourne une liste de produits dont le nom correspond au motif donné (avec LIKE)
// :x est un paramètre nommé, qu'on remplace par la valeur de "mc"
    List<Product> search(@Param("x") String mc);

    @Query("select p from Product p where p.price>:x")
    List<Product> searchByPrice(@Param("x") double price);

}
