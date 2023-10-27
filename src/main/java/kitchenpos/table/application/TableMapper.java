package kitchenpos.table.application;

import java.util.List;
import kitchenpos.table.domain.OrderTable;
import kitchenpos.table.domain.OrderTableRepository;
import org.springframework.stereotype.Component;

@Component
public class TableMapper {

    private final OrderTableRepository orderTableRepository;

    public TableMapper(OrderTableRepository orderTableRepository) {
        this.orderTableRepository = orderTableRepository;
    }

    public List<OrderTable> toOrderTables(List<Long> tableIds) {
        List<OrderTable> orderTables = orderTableRepository.findAllByIdIn(tableIds);
        if (orderTables.size() != tableIds.size()) {
            throw new IllegalArgumentException("존재하지 않는 테이블이 존재합니다.");
        }
        return orderTables;
    }
}
