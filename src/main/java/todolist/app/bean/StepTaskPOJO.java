package todolist.app.bean;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import todolist.app.model.Steps;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class StepTaskPOJO {
    
    private Steps step;
    private Integer idTask;
}
