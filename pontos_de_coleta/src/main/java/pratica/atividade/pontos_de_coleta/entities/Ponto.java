package pratica.atividade.pontos_de_coleta.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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

    @OneToOne(mappedBy = "ponto")
    private MateriaisPonto materiaisPonto;

    @ManyToOne
    @JoinColumn(name = "id_lixos")
    private List<LixoEletronico> lixos;
}
