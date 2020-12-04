package com.savior.company_service.service;

import com.savior.company_service.dao.Product.ProductDao;
import com.savior.company_service.model.Product;
import com.savior.company_service.utils.exception.data.KeyDoesNotExistException;
import com.savior.company_service.utils.exception.service.ProductDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  private final ProductDao productDao;

  @Autowired
  public ProductService(@Qualifier("mysql") ProductDao productDao) {
    this.productDao = productDao;
  }

  public Product insertProduct(Product product) {
//    Company storedCompany = getCompanyById(id);
//    product.setCompany(storedCompany);
    return productDao.insertProduct(product);
  }

  public List<Product> getAllProducts() {
    return productDao.selectAllProducts();
  }

  public Product getProductById(String id) throws ProductDoesNotExistException {
    try {
      return productDao.selectProductById(id);
    } catch (KeyDoesNotExistException kdne) {
      throw new ProductDoesNotExistException();
    }
  }

  public void deleteProduct(String id) throws ProductDoesNotExistException {
    try {
      productDao.deleteProductById(id);
    } catch (KeyDoesNotExistException kdne) {
      throw new ProductDoesNotExistException();
    }
  }

  public Product updateProduct(String id, Product newProduct) throws ProductDoesNotExistException {
    try {
      return productDao.updateProductById(id, newProduct);
    } catch (KeyDoesNotExistException kdne) {
      throw new ProductDoesNotExistException();
    }
  }

}
