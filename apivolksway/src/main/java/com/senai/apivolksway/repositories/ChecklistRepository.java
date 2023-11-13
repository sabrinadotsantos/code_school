package com.senai.apivolksway.repositories;

import com.senai.apivolksway.models.ChecklistModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChecklistRepository extends JpaRepository<ChecklistModel, UUID> {
    ChecklistModel findByFreio(Boolean freio);
}
