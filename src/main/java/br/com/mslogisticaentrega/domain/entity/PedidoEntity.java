package br.com.mslogisticaentrega.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_PEDIDO")
public class PedidoEntity {
    @Id
    private Integer id;
}
