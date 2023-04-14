package med.voll.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroPaciente(
        @NotBlank  // não pode ser vazio: precisa de um texto
        String nome,
        @NotBlank  // não pode ser vazio: precisa de um texto
        @Email // dar a formatação de e-mail
        String email,
        @NotBlank  // não pode ser vazio: precisa de um texto
        String telefone,
        @NotBlank  // não pode ser vazio: precisa de um texto
        @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")  // Dentro da segunda anotação, para esclarecer a quantidade de dígitos
        // passaremos a expressão regular
        String cpf,
        @NotNull // é um campo obrigatório
        @Valid  // para validar o DTO
        DadosEndereco endereco) {

}
