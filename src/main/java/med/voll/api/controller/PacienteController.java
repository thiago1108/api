package med.voll.api.controller;

import jakarta.annotation.PostConstruct;
import med.voll.api.paciente.DadosCadastroPaciente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PacienteController {

    @PostMapping
    public void cadastrar (@RequestBody DadosCadastroPaciente dados){
        System.out.println("dados recebidos: "+dados);
    }

}
