package com.example.appservice.controller;

import com.example.appservice.model.DataItem;
import com.example.appservice.repository.DataItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller.
 * GET /api/data  -> reads rows from the database container (proves app <-> db communication)
 */
@RestController
@RequestMapping("/api/data")
public class DataController {

    private final DataItemRepository repository;

    public DataController(DataItemRepository repository) {
        this.repository = repository;
    }

    // Return all records stored in app-db
    @GetMapping
    public List<DataItem> getAll() {
        return repository.findAll();
    }

    // Return one record by id
    @GetMapping("/{id}")
    public ResponseEntity<DataItem> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Insert a new record into app-db
    @PostMapping
    public DataItem create(@RequestBody DataItem item) {
        return repository.save(item);
    }
}
