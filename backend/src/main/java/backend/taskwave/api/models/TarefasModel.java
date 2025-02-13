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










}
