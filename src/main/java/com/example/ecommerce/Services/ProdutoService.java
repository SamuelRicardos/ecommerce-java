package com.example.ecommerce.Services;

import com.example.ecommerce.Model.Produtos;
import com.example.ecommerce.Repository.ProdutoRepository;
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
            produto.setCodigo(produtoAtualizado.getCodigo());
            produto.setNome(produtoAtualizado.getNome());
            produto.setPreco(produtoAtualizado.getPreco());
            return produtoRepository.save(produto);
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public void remover(String id) {
        produtoRepository.deleteById(id);
    }
}
