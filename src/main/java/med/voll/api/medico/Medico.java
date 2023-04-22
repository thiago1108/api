package med.voll.api.medico;
import jakarta.persistence.*;

//  importar a biblioteca Lombok, para gerar os códigos Java que faltam automaticamente.
//  Adicionaremos @Getter, @NoArgsConstructor, @AllArgsConstructor, @EqualsAndHashCode(of = "id")

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "medicos") // tabela medicos //add as anotações da JPA para transformar isso em uma entidade
@Entity(name = "Medico") // nome da entidade
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;
    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarinformacoes(DadosAtualizacaoMedico dados) {
       if (dados.nome()!= null) {
           this.nome = dados.nome();
       }
       if (dados.telefone() != null) {
           this.telefone = dados.telefone();
       }
       if (dados.endereco() != null) { // endereco e um objeot por isso muda o if
           this.endereco.atualizarInformacoes (dados.endereco());
       }


    }

    public void excluir() {
        this.ativo = false;
    }
}
