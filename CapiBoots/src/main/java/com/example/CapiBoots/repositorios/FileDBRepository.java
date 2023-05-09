package com.example.CapiBoots.repositorios;


import com.example.CapiBoots.modelos.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface File db repository.
 */
@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {



}