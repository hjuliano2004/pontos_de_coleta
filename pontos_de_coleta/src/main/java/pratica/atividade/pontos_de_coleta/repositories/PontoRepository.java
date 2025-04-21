package pratica.atividade.pontos_de_coleta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pratica.atividade.pontos_de_coleta.entities.Ponto;

public interface PontoRepository extends JpaRepository<Ponto, Long> {
    
}
