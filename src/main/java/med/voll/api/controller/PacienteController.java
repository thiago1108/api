package med.voll.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.paciente.DadosCadastroPaciente;
import med.voll.api.paciente.DadosListagemPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("pacientes")


public class PacienteController {

    @Autowired
    private PacienteRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar (@RequestBody  @Valid DadosCadastroPaciente dados){ repository.save(new Paciente(dados));}

    @GetMapping // metodo paginacao
    public Page<DadosListagemPaciente> listar(@PageableDefault(page = 0, size = 10, sort = {"nome"}) Pageable paginacao){ // criar DTO de Dados listagem medico // Pageabe para fazer paginacao e passa como paramentro no findall
        return repository.findAll(paginacao).map(DadosListagemPaciente::new); // findall devolver lista de medicos entao necessidade de uma conversao
    }


}



