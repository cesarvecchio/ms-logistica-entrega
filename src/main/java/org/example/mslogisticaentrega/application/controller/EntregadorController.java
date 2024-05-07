package org.example.mslogisticaentrega.application.controller;

import org.example.mslogisticaentrega.application.request.EntregadorRequest;
import org.example.mslogisticaentrega.application.response.EntregadorResponse;
import org.example.mslogisticaentrega.domain.service.EntregadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entregadores")
public class EntregadorController {

    private final EntregadorService entregadorService;

    public EntregadorController(EntregadorService entregadorService) {
        this.entregadorService = entregadorService;
    }

    @PostMapping
    public ResponseEntity<EntregadorResponse> criar(@RequestBody EntregadorRequest request) {
        return ResponseEntity.status(201).body(entregadorService.criar(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregadorResponse> buscar(@PathVariable Integer id) {

        return ResponseEntity.ok(entregadorService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntregadorResponse> atualizar(@PathVariable Integer id, @RequestBody EntregadorRequest request) {
        return ResponseEntity.ok(entregadorService.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EntregadorResponse> deletar(@PathVariable Integer id) {
        entregadorService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
