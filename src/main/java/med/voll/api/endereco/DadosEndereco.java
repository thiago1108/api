package med.voll.api.endereco;

//Bean Validation vai verificar, se as informações que chegam estão de acordo com as anotações.

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

// Classe Record Java vai criar uma classe imutável, em que cada um desses campos vai virar atributos com os
// métodos getters e setters e com os construtores, sem precisarmos fazer isso manualmente.
// O código fica mais simplificado ao usarmos record e o Spring cria de forma automática para nós.
// chamamos de padrão DTO - Data Transfer Object ("Objeto de transferência de dados").

public record DadosEndereco(
        @NotBlank  // não pode ser vazio: precisa de um texto
        String logradouro,
        @NotBlank // não pode ser vazio: precisa de um texto
        String bairro,
        @NotBlank // não pode ser vazio: precisa de um texto

        @Pattern(regexp = "\\d{8}")  // Dentro da segunda anotação, para esclarecer a quantidade de dígitos
        // passaremos a expressão regular
        String cep,
        @NotBlank // não pode ser vazio: precisa de um texto
        String cidade,
        @NotBlank // não pode ser vazio: precisa de um texto
        String uf,

        String complemento,
        String numero) {
}
