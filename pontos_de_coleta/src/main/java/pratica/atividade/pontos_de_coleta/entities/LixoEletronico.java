package pratica.atividade.pontos_de_coleta.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "lixo")
public class LixoEletronico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String descricao; 

    @OneToOne(mappedBy = "lixos")
    private Ponto ponto;

    @OneToMany(mappedBy = "lixoEletronico", cascade = CascadeType.ALL)
    private MateriaisPonto materiaisPonto;
}