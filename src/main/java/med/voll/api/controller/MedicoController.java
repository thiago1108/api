package med.voll.api.controller;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Para comunicarmos o Spring MVC que é uma classe controller utliza @RESTCONTOLLER por nao ser uma aplicacao web tradicional e sim uma API Rest,
// ao chegar uma requisição para /medicos o Spring vai detectar que deverá chamar o MedicoController

@RequestMapping ("medicos") // para informarmos qual a URL que esse controller vai responder

public class MedicoController {
    @Autowired //avisa ao Spring que esse novo atributo pelo ser instanciado. Faremos a injeção de dependências inserindo a anotação
    private MedicoRepository repository;

    @PostMapping // comunicando o Spring que ao chegar uma requisição do tipo post para a URL /medicos, ele deve chamar o método cadastrar da classe MedicoController

    @Transactional  // método de escrita, que consiste em um insert no banco de dados

    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }

    //@GetMapping // metodo listar
   // public List<DadosListagemMedico> listar(){ // criar DTO de Dados listagem medico
     //   return repository.findAll().stream().map(DadosListagemMedico::new).toList(); // findall devolver lista de medicos entao necessidade de uma conversao

    @GetMapping // metodo paginacao
    public Page<DadosListagemMedico> listar(Pageable paginacao){ // criar DTO de Dados listagem medico // Pageabe para fazer paginacao e passa como paramentro no findall
        return repository.findAll(paginacao).map(DadosListagemMedico::new); // findall devolver lista de medicos entao necessidade de uma conversao
    }

}

// para converter metodo stream .map que converte de medico para listagem medico e passa coo parametro onde chama o metodo construtor que esta na record dadoslistagem medico
// . tolist converte para lista