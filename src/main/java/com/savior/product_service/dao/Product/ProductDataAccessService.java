package com.savior.product_service.dao.Product;

import com.savior.product_service.model.Product;
import com.savior.product_service.repository.ProductRepository;
import com.savior.product_service.utils.exception.data.KeyDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductDataAccessService implements ProductDao {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public Product insertProduct(Product product) {
    return productRepository.save(product);
  }

  @Override
  public List<Product> selectAllProducts() {
    return productRepository.findAllProducts();
  }

  @Override
  public List<Product> selectAllProductsByCompanyId(String companyId) {
    return productRepository.findAllProductsByCompanyId(companyId);
  }

  @Override
  public Product selectProductById(String id) throws KeyDoesNotExistException {
    Optional<Product> storedProduct = productRepository.findProductById(id);
    if (storedProduct.isEmpty()) {
      throw new KeyDoesNotExistException();
    }
    return storedProduct.get();
  }

  @Override
  public void deleteProductById(String id) throws KeyDoesNotExistException {
    if (!productWithIdExists(id)) {
      throw new KeyDoesNotExistException();
    }
    productRepository.deleteById(id);
  }

  @Override
  public Product updateProductById(String id, Product product) throws KeyDoesNotExistException {
    Product updateProduct = selectProductById(id);
    updateProduct.setName(product.getName());
    return productRepository.save(updateProduct);
  }

  @Override
  public boolean productWithIdExists(String id) {
    return productRepository.existsById(id);
  }
}
