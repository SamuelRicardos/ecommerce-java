package com.example.ecommerce.Repository;

import com.example.ecommerce.Model.Produtos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ProdutoRepository extends MongoRepository<Produtos, String> {
}