package com.produtoapi.repository;

import com.produtoapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // This interface will automatically inherit methods for CRUD operations
    // from CrudRepository, such as save, findById, findAll, deleteById, etc.
    // No additional methods are needed unless specific queries are required.
}
