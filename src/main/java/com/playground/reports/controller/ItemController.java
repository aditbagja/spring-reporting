package com.playground.reports.controller;

import com.playground.reports.models.Item;
import com.playground.reports.service.ExcelGenerator;
import com.playground.reports.service.ItemService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Item>> getAllItem() {
        return ResponseEntity.ok(itemService.getAllItem());
    }

    @GetMapping("/download-excel")
    public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = HttpHeaders.CONTENT_DISPOSITION;
        String headerValue = "attachment; filename=items-" + currentDateTime + ".xlsx";
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM.toString());
        response.setHeader(headerKey, headerValue);

        List<Item> itemList = itemService.getAllItem();
        ExcelGenerator generator = new ExcelGenerator(itemList);
        generator.generateExcelFile(response);
    }
}
