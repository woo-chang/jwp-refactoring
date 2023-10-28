package kitchenpos.application;

import java.util.List;
import java.util.stream.Collectors;
import kitchenpos.domain.Product;
import kitchenpos.domain.ProductRepository;
import kitchenpos.dto.request.ProductCreateRequest;
import kitchenpos.dto.response.ProductResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> list() {
        return productRepository.findAll()
                .stream()
                .map(ProductResponse::from)
                .collect(Collectors.toList());
    }

    public ProductResponse create(ProductCreateRequest productCreateRequest) {
        Product product = new Product(productCreateRequest.getName(), productCreateRequest.getPrice());
        productRepository.save(product);
        return ProductResponse.from(product);
    }
}