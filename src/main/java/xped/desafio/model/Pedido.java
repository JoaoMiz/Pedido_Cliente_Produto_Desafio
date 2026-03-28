package xped.desafio.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // um pedido para um cliente
    @ManyToOne
    private Cliente cliente;

    // um pedido tem varios produtos
    @ManyToMany
    private List<Produto> produtos;

    private LocalDateTime data;
}