package kitchenpos.menu.domain.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MenuQuantity {

    private static final int MINIMUM_QUANTITY = 1;

    @Column(nullable = false)
    private long quantity;

    protected MenuQuantity() {
    }

    public MenuQuantity(long quantity) {
        validate(quantity);
        this.quantity = quantity;
    }

    private void validate(long quantity) {
        if (quantity < MINIMUM_QUANTITY) {
            throw new IllegalArgumentException("최소 1개의 수량은 필요합니다.");
        }
    }

    public long getQuantity() {
        return quantity;
    }
}