package com.produtoapi.service;
import com.produtoapi.model.Carro;
import com.produtoapi.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public Carro salvar(Carro carro){
        return carroRepository.save(carro);
    }

    public List<Carro> listarCarros() {
        return carroRepository.findAll();
    }

    public Optional<Carro> buscarPorId(long  id){
        return carroRepository.findById(id);
    }

    public void deletarPorId(long id){
        if(carroRepository.existsById(id)){
            carroRepository.deleteById(id);
        }else {
            throw new RuntimeException("Carro não encontrado");
        }
    }

    public Carro atualizar (@PathVariable long id, @RequestBody Carro carro){
        if (carroRepository.existsById(id)){
            carro.setId(id);
            return carroRepository.save(carro);
        } else {
            throw new RuntimeException("carro nao existe");
        }
    }
}
