package pratica.atividade.pontos_de_coleta.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "ponto_de_coleta")
public class Ponto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String endereco;

    private String diaColeta;

    @ManyToOne
    @JoinColumn(name = "lixo_id", nullable = false)
    private LixoEletronico lixoEletronico;
}
