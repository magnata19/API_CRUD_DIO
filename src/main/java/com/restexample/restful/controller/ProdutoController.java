package com.restexample.restful.controller;

import com.restexample.restful.entity.Produto;
import com.restexample.restful.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoService service;
    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<Produto> saveProduct(@RequestBody Produto produto) throws Exception{
        Produto produtoSalvo = service.saveProduct(produto);
        return new ResponseEntity<>(produtoSalvo, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        Produto byProductId = service.findByProductId(id);
        return new ResponseEntity<>(byProductId, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> all = service.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> alterarProduto(@RequestBody Produto produto, @PathVariable Long id) {
        Produto produtoAlterado = service.updateProduct(produto, id);
        return new ResponseEntity<>(produtoAlterado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable Long id) {
        service.deletarProduto(id);
        return new ResponseEntity<>("Produto deletado com sucesso!", HttpStatus.OK);
    }

}
