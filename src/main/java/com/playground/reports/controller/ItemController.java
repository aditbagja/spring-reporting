package com.playground.reports.controller;

import com.playground.reports.models.Item;
import com.playground.reports.repository.ItemRepository;
import com.playground.reports.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Controller
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping("/getItem")
    public ResponseEntity<List<Item>> getAllItem() {
        log.info("Starting /getItem");

        return ResponseEntity.ok(itemService.getAllItem());
    }
}
