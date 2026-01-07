package com.produtoapi.repository;
import java.util.*;
import com.produtoapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByNome  (String nome);
    List<Produto> findByNomeContaining  (String nome);
    List<Produto> findByNomeAndStatus  (String nome, String status);
    List<Produto> findByNomeStartingWith(String prefix);
    List<Produto> findByNomeEndingWith  (String suffix);
    List<Produto> findByPreco(Double preco);
    List<Produto> findByPrecoGreaterThan(Double preco);
    List<Produto> findByPrecoLessThan(Double preco);

    @Query("SELECT SUM(p.preco) FROM Produto p")
    Double findTotalPreco();

    List<Produto> findByQuantidade(Integer quantidade);
    List<Produto> findByQuantidadeLessThan(Integer quantidade);
    List<Produto> findByQuantidadeGreaterThan(Integer quantidade);

    @Query("Select p FROM Produto p WHERE p.quantidade = ?1 AND p.preco < ?2")
    List<Produto> buscarPorQuantidadeEPrecoMenorQue(Integer quantidade, Double preco);

}
