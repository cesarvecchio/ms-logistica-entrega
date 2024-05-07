package org.example.mslogisticaentrega.application.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.mslogisticaentrega.domain.entity.EntregadorEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorResponse {
    private String nome;
    private String cpf;
    private String email;

    public EntregadorResponse(EntregadorEntity entity) {
        this.nome = entity.getNome();
        this.cpf = entity.getCpf();
        this.email = entity.getEmail();
    }
}
