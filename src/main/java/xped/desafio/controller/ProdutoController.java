package xped.desafio.controller;

import xped.desafio.model.Produto;
import xped.desafio.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id).orElse(null);
    }

    @GetMapping("/nome/{nome}")
    public List<Produto> buscarPorNome(@PathVariable String nome) {
        return produtoService.buscarPorNome(nome);
    }

    @GetMapping("/contar")
    public long contarProdutos() {
        return produtoService.contarProdutos();
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoService.deletar(id);
    }
}