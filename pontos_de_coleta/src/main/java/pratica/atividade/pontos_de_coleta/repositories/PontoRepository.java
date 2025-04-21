package pratica.atividade.pontos_de_coleta.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pratica.atividade.pontos_de_coleta.entities.Ponto;

public interface PontoRepository extends JpaRepository<Ponto, Long> {
    List<Ponto> findByNomeContainingIgnoreCase(String tipo);

    @Query("SELECT m FROM ponto_de_coleta m  WHERE UPPER(m.tipo)  LIKE '%'||UPPER(:search)||'%'")
    List<Ponto> findByLixoEletronicoGetTipo(String search);
}