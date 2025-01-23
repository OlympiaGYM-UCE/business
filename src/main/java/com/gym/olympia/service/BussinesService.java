package com.gym.olympia.service;

import com.gym.olympia.entity.Bussines;
import com.gym.olympia.repository.BussinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BussinesService {

    @Autowired
    private BussinesRepository bussinesRepository;

    public List<Bussines> listarTodas() {
        return bussinesRepository.findAll();
    }

    public Optional<Bussines> buscarPorId(Long id) {
        return bussinesRepository.findById(id);
    }

    public Bussines guardar(Bussines bussines) {
        return bussinesRepository.save(bussines);
    }

    public Bussines actualizar(Long id, Bussines bussines) {
        return bussinesRepository.findById(id).map(existingBussines -> {
            existingBussines.setNombre(bussines.getNombre());
            existingBussines.setTelefono(bussines.getTelefono());
            existingBussines.setEmail(bussines.getEmail());
            return bussinesRepository.save(existingBussines);
        }).orElseThrow(() -> new RuntimeException("Bussines  dont find with id " + id));
    }

    public void eliminar(Long id) {
        bussinesRepository.deleteById(id);
    }
}