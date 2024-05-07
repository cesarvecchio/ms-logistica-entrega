package org.example.mslogisticaentrega.domain.service;

import org.example.mslogisticaentrega.application.controller.exceptions.NaoEncontradoException;
import org.example.mslogisticaentrega.application.request.EntregadorRequest;
import org.example.mslogisticaentrega.application.response.EntregadorResponse;
import org.example.mslogisticaentrega.domain.entity.EntregadorEntity;
import org.example.mslogisticaentrega.infra.repository.EntregadorRepository;
import org.example.mslogisticaentrega.utils.Utils;
import org.springframework.stereotype.Service;

@Service
public class EntregadorService {
    private final EntregadorRepository entregadorRepository;

    public EntregadorService(EntregadorRepository entregadorRepository) {
        this.entregadorRepository = entregadorRepository;
    }

    public EntregadorResponse criar(EntregadorRequest request) {
        EntregadorEntity entity = entregadorRepository.saveAndFlush(request.toEntity());

        return new EntregadorResponse(entity);
    }

    public EntregadorResponse buscarPorId(Integer id) {
        return new EntregadorResponse(validarPorId(id));
    }

    public EntregadorResponse atualizar(Integer id, EntregadorRequest request) {
        EntregadorEntity entregador = validarPorId(id);

        Utils.copyNonNullProperties(request, entregador);

        return new EntregadorResponse(entregadorRepository.save(entregador));
    }

    public void deletar(Integer id) {
        entregadorRepository.delete(validarPorId(id));
    }

    private EntregadorEntity validarPorId(Integer id) {
        return entregadorRepository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException(
                        String.format("Entregador com o id:{%s} nao foi encontrado!", id)
                ));
    }


}
