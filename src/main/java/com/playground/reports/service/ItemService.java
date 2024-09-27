package com.playground.reports.service;

import com.playground.reports.models.Item;
import com.playground.reports.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public void executeDumpData() {
        for (int i = 1; i <= 10; i++) {
            itemRepository.save(new Item("Item " + i));
        }
    }

    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }
}
