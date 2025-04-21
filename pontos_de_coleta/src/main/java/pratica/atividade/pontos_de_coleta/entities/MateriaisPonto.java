package pratica.atividade.pontos_de_coleta.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "lixo_ponto")
public class MateriaisPonto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_Ponto")
    private Ponto ponto;

    @ManyToOne
    @JoinColumn(name = "lixo_id")
    private LixoEletronico lixoEletronico;

    @Column(nullable = false)
    private BigDecimal capMaxima;

    
}