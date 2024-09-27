package com.playground.reports.repository;

import com.playground.reports.models.Item;
import org.springframework.data.repository.ListCrudRepository;

public interface ItemRepository extends ListCrudRepository<Item, Long> {
}
