package com.restexample.restful.service;

import com.restexample.restful.entity.Produto;
import com.restexample.restful.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto saveProduct(Produto produto) {
        return repository.save(produto);
    }

    public Produto findByProductId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Produto updateProduct(Produto produto, Long id) {
        Optional<Produto> byId = repository.findById(id);
            if(byId.isPresent()) {
                Produto novoProduto = byId.get();
                novoProduto.setNome(produto.getNome());
                novoProduto.setPreco(produto.getPreco());
                novoProduto.setDescricao(produto.getDescricao());
                return repository.save(novoProduto);
            } else {
                throw new RuntimeException("Produto não encontrado.");
            }
    }

    public void deletarProduto(Long id) {
        repository.deleteById(id);
    }
}
