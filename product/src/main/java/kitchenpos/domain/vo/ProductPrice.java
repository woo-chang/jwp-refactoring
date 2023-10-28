package kitchenpos.domain.vo;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductPrice {

    @Column(nullable = false)
    private BigDecimal price;

    protected ProductPrice() {
    }

    public ProductPrice(BigDecimal price) {
        validate(price);
        this.price = price;
    }

    private void validate(BigDecimal price) {
        if (price == null) {
            throw new IllegalArgumentException("상품 가격이 존재하지 않습니다.");
        }
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("상품 가격이 0보다 작을 수 없습니다.");
        }
    }

    public BigDecimal getPrice() {
        return price;
    }
}