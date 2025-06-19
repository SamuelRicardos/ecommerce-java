package com.example.ecommerce.Controller;

import com.example.ecommerce.Model.Produtos;
import com.example.ecommerce.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produtos> listar() {
        return produtoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Produtos buscarPorId(@PathVariable String id) {
        return produtoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    @PostMapping
    public Produtos cadastrar(@RequestBody Produtos produto) {
        return produtoService.cadastrar(produto);
    }

    @PutMapping("/{id}")
    public Produtos atualizar(@PathVariable String id, @RequestBody Produtos produto) {
        return produtoService.atualizar(id, produto);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable String id) {
        produtoService.remover(id);
    }
}
