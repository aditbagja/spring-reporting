package com.playground.reports;

import com.playground.reports.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ReportsApplication implements ApplicationRunner {

    @Autowired
    ItemService itemService;

    public static void main(String[] args) {
        SpringApplication.run(ReportsApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        itemService.executeDumpData();
    }

}
