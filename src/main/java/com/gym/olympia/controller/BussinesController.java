package com.gym.olympia.controller;

import com.gym.olympia.entity.Bussines;
import com.gym.olympia.service.BussinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class BussinesController {

    @Autowired
    private BussinesService bussinesService;

    @GetMapping
    public List<Bussines> listarTodas() {
        return bussinesService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bussines> buscarPorId(@PathVariable Long id) {
        return bussinesService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Bussines crear(@RequestBody Bussines bussines) {
        return bussinesService.guardar(bussines);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bussines> actualizar(@PathVariable Long id, @RequestBody Bussines bussines) {
        try {
            Bussines bussinesActualizada = bussinesService.actualizar(id, bussines);
            return ResponseEntity.ok(bussinesActualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        bussinesService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}