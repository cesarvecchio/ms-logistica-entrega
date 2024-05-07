package org.example.mslogisticaentrega.application.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.mslogisticaentrega.domain.entity.EntregadorEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {
    private String nome;
    private String cpf;
    private String email;

    public EntregadorEntity toEntity() {
        return new EntregadorEntity(nome, cpf, email);
    }
}
