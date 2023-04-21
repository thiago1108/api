package med.voll.api.medico;

//DTO campos que vou devolver para backend apenas a informaçoes necesssarias

public record DadosListagemMedico(Long id, String nome, String email,  String crm, Especialidade especialidade) {


    //metodo construtor que é chamdo pela medico controle metodo listar
    public DadosListagemMedico (Medico medico) {
        this(medico.getId(),medico.getNome(), medico.getEmail(), medico.getCrm(),medico.getEspecialidade());
    }
}
