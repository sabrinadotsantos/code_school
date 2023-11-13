package com.senai.apivolksway.repositories;

import com.senai.apivolksway.models.InteresseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.BitSet;
import java.util.UUID;

@Repository
public interface InteresseRepository extends JpaRepository<InteresseModel, UUID> {
    InteresseModel findByEmail(BitSet email);
}
