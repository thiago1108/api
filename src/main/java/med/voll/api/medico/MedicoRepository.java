package med.voll.api.medico;

import org.springframework.data.jpa.repository.JpaRepository;

// interface Java, sem elementos do Spring Data. Vamos herdar de uma interface chamada JpaRepository, usando um extends.
// Entre <>, passaremos dois tipos de objeto.
// O primeiro será o tipo da entidade trabalhada pelo repository, Medico, e o tipo do atributo da chave primária da entidade,
// Long

public interface MedicoRepository extends JpaRepository <Medico, Long> {

}
