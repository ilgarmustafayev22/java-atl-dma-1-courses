package az.atlacademy.productms.controller;

import az.atlacademy.productms.ProductMsApplication;
import az.atlacademy.productms.dao.repository.ProductRepository;
import az.atlacademy.productms.model.ProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ProductMsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableConfigurationProperties
@ActiveProfiles(profiles = "integration")
@EnableJpaRepositories(basePackages = "az.atlacademy.productms.dao.repository")
class ProductControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Sql(scripts = "classpath:sql/create-product.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void givenGetProductByIdWhenFoundThenReturnDto() {
        ResponseEntity<ProductDto> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/product-app/api/v1/products/1", ProductDto.class
        );
        ProductDto productDto = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(productDto);
        assertEquals("Test", productDto.getName());
    }

}