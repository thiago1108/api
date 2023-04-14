package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedico(
        @NotBlank  // não pode ser vazio: precisa de um texto
        String nome,
        @NotBlank  // não pode ser vazio: precisa de um texto
        String telefone,
        @NotBlank // não pode ser vazio: precisa de um texto
        @Email  // dar a formatação de e-mail
        String email,
        @NotBlank  // não pode ser vazio: precisa de um texto

        @Pattern(regexp = "\\d{4,6}")  // Dentro da segunda anotação, para esclarecer a quantidade de dígitos
        // passaremos a expressão regular
        String crm,
        @NotNull // é um campo obrigatório
        Especialidade especialidade,
        @NotNull  // não pode ser vazio: precisa de um texto
        @Valid   // para validar o DTO
        DadosEndereco endereco ) {
}
