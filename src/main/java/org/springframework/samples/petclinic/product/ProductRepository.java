package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAll();

    @Query("SELECT p FROM Product p") // TODO Missing "where". Check correct
    List<ProductType> findAllProductTypes();

    Optional<Product> findById(int id);

    Product findByName(String name);

    Product save(Product p);

    @Query("Select p.productType FROM Product p WHERE p.productType.name like %?1") // TODO check correct
    ProductType findProductTypeByName(String name);
}
