package backend.taskwave.api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Tb_tarefas")
public class TarefasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    @NotBlank(message = "o campo título é obrigatório")
    private String titulo;

    @Column(name = "status")
    @NotBlank(message = "o campo de status é obrigatório")
    private String status;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data_criacao")
    private String data_cracao;

    @Column(name = "usuario_id")
    private Long usuario_id;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getStatus() {
        return status;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData_cracao() {
        return data_cracao;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }
}
