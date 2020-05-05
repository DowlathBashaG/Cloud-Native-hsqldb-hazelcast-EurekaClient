package io.dowlath.product.repository;

import io.dowlath.product.entity.Product;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Cacheable("productsByCategoryCache")
    List<Product> findByCatId(int catId);
}
