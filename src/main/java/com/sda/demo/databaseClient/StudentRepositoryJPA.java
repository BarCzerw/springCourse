package com.sda.demo.databaseClient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositoryJPA extends JpaRepository<Student,Long> {
}
