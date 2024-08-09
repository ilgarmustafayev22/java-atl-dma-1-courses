package az.atlacademy.productms.service.impl;

import az.atlacademy.productms.dao.entity.ProductEntity;
import az.atlacademy.productms.dao.repository.ProductRepository;
import az.atlacademy.productms.exception.ProductNotFound;
import az.atlacademy.productms.mapper.ProductMapper;
import az.atlacademy.productms.model.ProductDto;
import az.atlacademy.productms.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public void createProduct(ProductDto productDto) {
        productRepository.save(productMapper.toEntity(productDto));
    }

    @Override
    public ProductDto findById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toDto)
                .orElseThrow(() -> new ProductNotFound("product not found with id" + id));
    }

    @Override
    @Transactional
    public void updateProduct(Long id, ProductDto productDto) {
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFound("product not found with id" + id));

        productEntity.setCount(productEntity.getCount());
        productEntity.setName(productEntity.getName());
        productEntity.setPrice(productEntity.getPrice());

        productRepository.save(productEntity);
    }

    @Override
    @Transactional
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

}
