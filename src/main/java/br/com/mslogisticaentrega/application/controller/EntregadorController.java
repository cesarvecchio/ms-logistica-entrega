package br.com.mslogisticaentrega.application.controller;

import br.com.mslogisticaentrega.application.request.EntregadorRequest;
import br.com.mslogisticaentrega.application.response.EntregadorResponse;
import br.com.mslogisticaentrega.domain.service.EntregadorService;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.status(HttpStatus.CREATED).body(entregadorService.criar(request));
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
