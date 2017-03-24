package com.github.s_matyukevich.spring_boot.domain.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface StockItemRepository extends CrudRepository<StockItem, Long> {
    List<StockItem> findByType(ItemType type);
}
