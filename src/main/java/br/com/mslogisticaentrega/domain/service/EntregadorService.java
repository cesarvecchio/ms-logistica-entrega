package br.com.mslogisticaentrega.domain.service;

import br.com.mslogisticaentrega.application.controller.exceptions.JaCadastradoException;
import br.com.mslogisticaentrega.application.controller.exceptions.NaoEncontradoException;
import br.com.mslogisticaentrega.application.request.EntregadorRequest;
import br.com.mslogisticaentrega.application.response.EntregadorResponse;
import br.com.mslogisticaentrega.domain.entity.EntregadorEntity;
import br.com.mslogisticaentrega.infra.repository.EntregadorRepository;
import br.com.mslogisticaentrega.utils.Utils;
import org.springframework.stereotype.Service;

@Service
public class EntregadorService {
    private final EntregadorRepository entregadorRepository;

    public EntregadorService(EntregadorRepository entregadorRepository) {
        this.entregadorRepository = entregadorRepository;
    }

    public EntregadorResponse criar(EntregadorRequest request) {
        validarCpf(request.getCpf());

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

    private void validarCpf(String cpf){
        if(entregadorRepository.existsByCpf(cpf)) {
            throw new JaCadastradoException(String.format("Entregador com cpf:{%s} ja esta cadastrado!", cpf));
        }
    }

}
