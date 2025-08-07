package com.produtoapi.service;
import com.produtoapi.model.Produto;
import com.produtoapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(Produto Produto) {
        return produtoRepository.save(Produto);
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public void deletar(long id){
        produtoRepository.deleteById(id);
    }

    public Optional<Produto> buscarPorId(long id){
        return produtoRepository.findById(id);
    }

    public Produto atualizar(long id, Produto produto){
        if (produtoRepository.existsById(id)){
            produto.setId(id);
            return produtoRepository.save(produto);
        }
        else {
            throw new RuntimeException("Produto não encontrado com o ID: " + id);
        }
    }
}
