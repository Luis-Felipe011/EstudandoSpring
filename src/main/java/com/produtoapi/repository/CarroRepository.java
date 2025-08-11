package com.produtoapi.repository;

import com.produtoapi.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    // This interface will automatically inherit methods for CRUD operations
    // from CrudRepository, such as save, findById, findAll, deleteById, etc.
    // No additional methods are needed unless specific queries are required.
}
