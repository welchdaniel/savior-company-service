package com.savior.company_service.repository;

import com.savior.company_service.constants.Constants;
import com.savior.company_service.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, String> {
  @Query(value = "SELECT * FROM " + Constants.PRODUCT_TABLE + " WHERE deleted_at IS NULL", nativeQuery = true)
  List<Product> findAllProducts();

  @Query(value = "SELECT * FROM " + Constants.PRODUCT_TABLE + " WHERE company_id = :cid AND deleted_at IS NULL", nativeQuery = true)
  List<Product> findAllProductsByCompanyId(@Param("cid") String id);

  @Query(value = "SELECT * FROM " + Constants.PRODUCT_TABLE + " WHERE id = :pid AND deleted_at IS NULL", nativeQuery = true)
  Optional<Product> findProductById(@Param("pid") String id);

  // TODO: implement products pagination
  Page<Product> findProductByCompanyId(String companyId, Pageable pageable);
}
