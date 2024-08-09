package az.atlacademy.productms.service;

import az.atlacademy.productms.model.ProductDto;

public interface ProductService {

    void createProduct(ProductDto productDto);

    ProductDto findById(Long id);

    void updateProduct(Long id, ProductDto productDto);

    void deleteProduct(long id);

}
