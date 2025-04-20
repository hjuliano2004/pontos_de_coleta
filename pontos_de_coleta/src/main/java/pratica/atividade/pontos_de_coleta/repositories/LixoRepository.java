package pratica.atividade.pontos_de_coleta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pratica.atividade.pontos_de_coleta.entities.LixoEletronico;

public interface LixoRepository extends JpaRepository<LixoEletronico, Long> {
    
}