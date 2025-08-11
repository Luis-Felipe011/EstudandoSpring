package com.produtoapi.controller;

import com.produtoapi.model.Casa;
import com.produtoapi.service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Casas")
public class CasaController {
    @Autowired
    private CasaService casaService;

    @GetMapping
    public List<Casa> listarCasas() {
        return casaService.listarCasas();
    }

    @PostMapping
    public Casa salvar(@RequestBody Casa casa){
        return casaService.salvar(casa);
    }

    @PutMapping ("/{id}")
    public Casa atualizar(@RequestBody Casa casa, @PathVariable long id){
        return casaService.atualizar(casa, id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id){
        casaService.deletar(id);
    }

    @GetMapping("/{id}")
    public Optional<Casa> buscarPorId(@PathVariable long id ){
        return casaService.buscarPorId(id);
    }

}
