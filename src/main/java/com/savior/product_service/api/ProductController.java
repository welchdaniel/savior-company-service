package com.savior.product_service.api;

import com.savior.product_service.model.Product;
import com.savior.product_service.service.ProductService;
import com.savior.product_service.utils.exception.http.NotFoundException;
import com.savior.product_service.utils.exception.service.ProductDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/product")
@RestController
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping
  public ResponseEntity getAllProducts() {
    List<Product> storedProducts = productService.getAllProducts();
    return new ResponseEntity(storedProducts, HttpStatus.OK);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity getProductById(@PathVariable("id") String id) {
    try {
      Product storedProduct = productService.getProductById(id);
      return new ResponseEntity(storedProduct, HttpStatus.OK);
    } catch (ProductDoesNotExistException pdne) {
      throw new NotFoundException(pdne.getMessage());
    }
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity deleteProductById(@PathVariable("id") String id) {
    try {
      productService.deleteProduct(id);
      return new ResponseEntity(HttpStatus.OK);
    } catch (ProductDoesNotExistException pdne) {
      throw new NotFoundException(pdne.getMessage());
    }
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
    try {
      Product storedProduct = productService.updateProduct(id, product);
      return new ResponseEntity(storedProduct, HttpStatus.OK);
    } catch (ProductDoesNotExistException pdne) {
      throw new NotFoundException(pdne.getMessage());
    }
  }
}
