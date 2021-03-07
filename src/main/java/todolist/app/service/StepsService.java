package todolist.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import todolist.app.bean.StepTaskPOJO;
import todolist.app.model.Steps;
import todolist.app.model.TaskList;
import todolist.app.repository.StepsRepository;
import todolist.app.repository.TaskListRepository;

@Service
public class StepsService {

    @Autowired
    private StepsRepository stepsRepository;

    @Autowired
    private TaskListRepository taskListRepository;

    public Steps saveSteps(StepTaskPOJO obj) {
        Steps p = new Steps();
        p = obj.getStep();
        Integer id = obj.getIdTask();
        TaskList task = taskListRepository.findById(id).orElse(null);

        if (p.getId() == null) {

            Date d = new Date();

            System.out.println(d);
            p.setTitle(p.getTitle());
            p.setTask(task);
            return stepsRepository.save(p);
        } else {
            return stepsRepository.save(p);
        }
    }

    public ResponseEntity<List<Steps>> getByTaskId(Integer id) {
        
        List<Steps> s = stepsRepository.findByTaskID(id);
        return ResponseEntity.ok().body(s);
    }

    public ResponseEntity<Steps> DeleteTask(Integer id) {
        Steps task = stepsRepository.findById(id).orElse(null);
        stepsRepository.delete(task);
        return ResponseEntity.ok().body(task);
    }

}
