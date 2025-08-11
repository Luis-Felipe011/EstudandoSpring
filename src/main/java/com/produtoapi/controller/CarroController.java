package com.produtoapi.controller;

import com.produtoapi.model.Carro;
import com.produtoapi.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping ("/Carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping
    public Carro salvar (@RequestBody Carro carro){
        return carroService.salvar(carro);
    }

    @GetMapping
    public List<Carro> listarCarros (){
        return carroService.listarCarros();
    }

    @GetMapping("/{id}")
    public Optional<Carro> buscarPorId(@PathVariable long id){
        return carroService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable long id){
        carroService.deletarPorId(id);
    }

    @PutMapping("/{id}")
    public Carro atualizar (@PathVariable long id, @RequestBody Carro carro) {
        return carroService.atualizar(id, carro);
    }


}
