package com.example.appservice;

import com.example.appservice.model.DataItem;
import com.example.appservice.repository.DataItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/** Inserts sample rows at startup (only if the table is empty) so GET /api/data returns something. */
@Component
public class DataLoader implements CommandLineRunner {

    private final DataItemRepository repository;

    public DataLoader(DataItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            repository.save(new DataItem("Item 1", "First record from app-db"));
            repository.save(new DataItem("Item 2", "Second record from app-db"));
            repository.save(new DataItem("Item 3", "Third record from app-db"));
        }
    }
}
