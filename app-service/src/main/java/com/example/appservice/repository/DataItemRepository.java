package com.example.appservice.repository;

import com.example.appservice.model.DataItem;
import org.springframework.data.jpa.repository.JpaRepository;

/** Spring Data generates all CRUD queries automatically. */
public interface DataItemRepository extends JpaRepository<DataItem, Long> {
}
