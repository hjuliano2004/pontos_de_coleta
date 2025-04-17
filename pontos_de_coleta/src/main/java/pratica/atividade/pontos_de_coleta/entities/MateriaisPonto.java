package pratica.atividade.pontos_de_coleta.entities;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "materiais_ponto")
public class MateriaisPonto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(nullable = false, name = "id_ponto")
    private Ponto ponto;

    @OneToMany
    @JoinColumn(name = "id_lixo")
    private List<LixoEletronico> lixoEletronico = new ArrayList<>();

    private int capMaxima; 

    public boolean excessivo(){
        if(capMaxima > lixoEletronico.size()){
            return true;
        }
        return false;
    }

}