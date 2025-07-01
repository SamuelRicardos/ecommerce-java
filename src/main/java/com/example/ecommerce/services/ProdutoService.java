package com.example.ecommerce.services;

import com.example.ecommerce.model.Produtos;
import com.example.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produtos> listarTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produtos> buscarPorId(String id) {
        return produtoRepository.findById(id);
    }

    public Produtos cadastrar(Produtos produto) {
        return produtoRepository.save(produto);
    }

    public Produtos atualizar(String id, Produtos produtoAtualizado) {
        return produtoRepository.findById(id).map(produto -> {
            produto.setNome(produtoAtualizado.getNome());
            produto.setPreco(produtoAtualizado.getPreco());
            produto.setCategorias(produtoAtualizado.getCategorias());
            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setQuantidadeEstoque(produtoAtualizado.getQuantidadeEstoque());
            produto.setImagemUrl(produtoAtualizado.getImagemUrl());
            return produtoRepository.save(produto);
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public void remover(String id) {
        produtoRepository.deleteById(id);
    }
}
