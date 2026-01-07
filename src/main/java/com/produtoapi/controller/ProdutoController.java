package com.produtoapi.controller;

import com.produtoapi.model.Produto;
import com.produtoapi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin (origins = "*")
@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto>  listarProdutos() {
        return produtoService.listarProdutos();
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        return produtoService.salvar(produto);
    }

    @PutMapping("/{id}")
    public Produto atualizar (@PathVariable long id, @RequestBody Produto produto){
        return produtoService.atualizar(id, produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id){
        produtoService.deletar(id);
    }

    @GetMapping("/{id}")
    public Optional<Produto> buscarPorId(@PathVariable long id){
        return produtoService.buscarPorId(id);
    }

    @PostMapping("/salvarLista")
    public List<Produto> salvarLista(@RequestBody List<Produto> produtos){
        return produtoService.salvarLista(produtos);
    }

    @GetMapping("/buscarPorNome")
    public List<Produto> FindByNome  (@RequestParam String nome){
        return produtoService.FindByNome(nome);
    }

    @GetMapping("/buscarPorNomeContendo")
    public List<Produto> FindByNomeContaining (@RequestParam String nome){
        return produtoService.FindByNomeContaining(nome);
    }

    @GetMapping ("/buscarPorNomeEStatus")
    public List<Produto> FindByNomeAndStatus (@RequestParam String nome, @RequestParam String status) {
        return produtoService.FindByNomeAndStatus(nome, status);
    }

    @GetMapping("/buscarPorNomeIniciandoCom")
    public List<Produto> FindByNomeStartingWith (@RequestParam String prefix){
        return produtoService.FindByNomeStartingWith(prefix);
    }

    @GetMapping("/buscarPorNomeTerminandoCom")
    public List<Produto> FindByNomeEndingWith  (@RequestParam String suffix){
        return produtoService.FindByNomeEndingWith(suffix);
    }

    @GetMapping("/buscarPorPreco")
    public List<Produto> FindByPreco(@RequestParam Double preco){
        return produtoService.FindByPreco(preco);
    }

    @GetMapping("/buscarPorPrecoMaiorQue")
    public List<Produto> FindByPrecoGreaterThan (@RequestParam Double preco){
        return produtoService.FindByPrecoGreaterThan(preco);
    }

    @GetMapping("/buscarPorPrecoMenorQue")
    public List<Produto> findByPrecoLessThan (@RequestParam Double preco){
    return produtoService.FindByPrecoLessThan(preco);
    }

    @GetMapping("/valorTotalDosProdutos")
        public Double FindTotalPreco (){
            return  produtoService.FindTotalPreco();
    }

    @GetMapping("/buscarPorQuantidade")
    public List<Produto> FindByQuantidade (@RequestParam Integer quantidade){
        return produtoService.FindByQuantidade(quantidade);
    }

    @GetMapping("/buscarPorQuantidadeMenorQue")
    public List<Produto> FindByQuantidadeLessThan (@RequestParam Integer quantidade){
        return produtoService.FindByQuantidadeLessThan(quantidade);
    }

    @GetMapping("BuscarPorQuantidadeMaiorQue")
    public List<Produto> FindByQuantidadeGreaterThan (@RequestParam Integer quantidade){
        return produtoService.FindByQuantidadeGreaterThan(quantidade);
    }

    @GetMapping ("/BuscarPorQuantidadeEPrecoMenorQue")
    public List<Produto> BuscarPorQuantidadeEPrecoMenorQue(@RequestParam Integer quantidade, @RequestParam Double preco){
        return produtoService.BuscarPorQuantidadeEPrecoMenorQue(quantidade, preco);
    }
}