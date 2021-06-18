package org.example.clickcounter.repository;

import org.example.clickcounter.model.Button;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ButtonRepo extends JpaRepository<Button, Integer> {
}
