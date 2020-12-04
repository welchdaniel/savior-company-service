package com.savior.company_service.dao.Product;

import com.savior.company_service.model.Product;
import com.savior.company_service.utils.exception.data.KeyDoesNotExistException;

import java.util.List;

public interface ProductDao {

  Product insertProduct(Product product);

  List<Product> selectAllProducts();

  List<Product> selectAllProductsByCompanyId(String companyId);

  Product selectProductById(String id) throws KeyDoesNotExistException;

  void deleteProductById(String id) throws KeyDoesNotExistException;

  Product updateProductById(String id, Product product) throws KeyDoesNotExistException;

  boolean productWithIdExists(String id);

}