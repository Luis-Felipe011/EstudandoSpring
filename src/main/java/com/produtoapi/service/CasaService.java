package com.produtoapi.service;
import com.produtoapi.model.Casa;
import com.produtoapi.repository.CasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CasaService {

    @Autowired
    private CasaRepository casaRepository;

    // metodo para salvar uma casa
    public Casa salvar(Casa casa){
        return casaRepository.save(casa);
    }

    // metodos para retornar uma casa
    public List<Casa> listarCasas(){
        return casaRepository.findAll();
    }

    // metodo para atualizar
    public Casa atualizar (Casa casa, long id){
        if (casaRepository.existsById(id)){
            casa.setId(id);
            return casaRepository.save(casa);
        } else {
            throw new RuntimeException("Casa não encontrada com o ID: " + id);
        }
    }

    // metodo para deletar
    public void deletar(long id) {
        if (casaRepository.existsById(id)) {
            casaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Casa não encontrada");
        }
    }

    public Optional<Casa> buscarPorId(long id) {
        if (casaRepository.existsById(id)) {
            return casaRepository.findById(id);
        } else {
            throw new RuntimeException("Produto nao entrado");
        }
    }


}
