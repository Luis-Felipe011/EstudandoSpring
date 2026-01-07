package com.produtoapi.service;
import com.produtoapi.model.Produto;
import com.produtoapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public List<Produto> salvarLista(List<Produto> produtos){
        return produtoRepository.saveAll(produtos);
    }

    // ===========================================================================
    // ==================== Busca avançadas por nome do produto ==================
    // ===========================================================================

    public List<Produto> FindByNome  (String nome){
        return produtoRepository.findByNome(nome);
    }

    public List<Produto> FindByNomeContaining (String Nome){
        return produtoRepository.findByNomeContaining(Nome);
    }

    public List<Produto> FindByNomeAndStatus (String Nome , String Status){
        return produtoRepository.findByNomeAndStatus(Nome, Status);
    }

    public List<Produto> FindByNomeStartingWith (String Prefix){
        return produtoRepository.findByNomeStartingWith(Prefix);
    }

    public List<Produto> FindByNomeEndingWith (String Suffix){
        return produtoRepository.findByNomeEndingWith(Suffix);
    }

    public List<Produto> FindByPreco (Double Preco){
        return produtoRepository.findByPreco(Preco);
    }

    public List<Produto> FindByPrecoGreaterThan (Double Preco){
        return produtoRepository.findByPrecoGreaterThan(Preco);
    }

    public List<Produto> FindByPrecoLessThan (Double Preco){
        return produtoRepository.findByPrecoLessThan(Preco);
    }

    public Double FindTotalPreco(){
        return produtoRepository.findTotalPreco();
    }

    public List<Produto> FindByQuantidade (Integer quantidade){
        return produtoRepository.findByQuantidade(quantidade);
    }

    public List<Produto> FindByQuantidadeLessThan (Integer quantidade){
        return produtoRepository.findByQuantidadeLessThan(quantidade);
    }

    public List<Produto> FindByQuantidadeGreaterThan(Integer quantidade){
        return produtoRepository.findByQuantidadeGreaterThan(quantidade);
    }

    public List<Produto> BuscarPorQuantidadeEPrecoMenorQue(Integer quantidade, Double preco){
        return produtoRepository.buscarPorQuantidadeEPrecoMenorQue(quantidade, preco);
    }
}
