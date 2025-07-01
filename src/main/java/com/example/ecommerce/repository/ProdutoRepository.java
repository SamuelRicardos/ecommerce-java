package com.example.ecommerce.repository;

import com.example.ecommerce.Model.Produtos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends MongoRepository<Produtos, String> {
}