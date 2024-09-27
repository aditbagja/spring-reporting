package com.playground.reports.controller;

import com.playground.reports.service.ItemService;
import com.playground.reports.service.JasperReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
public class ReportController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private JasperReportService jasperReportService;

    @GetMapping("/item-report/{format}")
    public ResponseEntity<Resource> getItemReport(@PathVariable String format) {
        byte[] reportContent = jasperReportService.getItemReport(itemService.getAllItem(), format);

        ByteArrayResource resource = new ByteArrayResource(reportContent);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(resource.contentLength())
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        ContentDisposition.attachment()
                                .filename("item-report." + format)
                                .build().toString())
                .body(resource);
    }
}
