package todolist.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import todolist.app.model.DateModel;
import todolist.app.model.Menu;
import todolist.app.model.TaskList;
import todolist.app.model.TodoTask;
import todolist.app.repository.DateModelRepository;
import todolist.app.repository.MenuRepository;
import todolist.app.repository.TaskListRepository;
import todolist.app.repository.TodoTaskRepository;

@Service
public class TaskListService {
    
    @Autowired
    private TaskListRepository taskRepository;

    @Autowired
    private MenuRepository menuRepository;

   @Autowired
   private DateModelRepository dateModelRepository;



    public TaskList saveTasks(TaskList obj){
     if(obj.getId() == null)
     {
         
         Date d = new Date();
         obj.setCreatedOn(d);
         System.out.println(d);
         obj.setTitle(obj.getTitle());
         obj.setDueDate(obj.getDueDate());
        return taskRepository.save(obj); 
     }
     else{
     return taskRepository.save(obj);
     }
    }

    public ResponseEntity<List<Menu>> getAllMenu(){
        List<Menu> menu = menuRepository.findAll();
        return ResponseEntity.ok().body(menu);
    
    }

    public ResponseEntity<List<DateModel>> getAllDatesModel(){
        List<DateModel> menu = dateModelRepository.findAll();
        return ResponseEntity.ok().body(menu);
    }
    public ResponseEntity<List<TaskList>> getAllTask(){
        List<TaskList> task = taskRepository.findAll();
        return ResponseEntity.ok().body(task);
    }

  

    public ResponseEntity<TaskList> getById(Integer id){
        TaskList task = taskRepository.findById(id).orElse(null);
        return ResponseEntity.ok().body(task);
    }

  
    public ResponseEntity<List<TaskList>> getImportantTask(){
      List<TaskList> t =  taskRepository.findByImportant();
      return ResponseEntity.ok().body(t);
    }

  public ResponseEntity<List<TaskList>> getCompletedTask(){
    List<TaskList> t =  taskRepository.findByCompleted();
    return ResponseEntity.ok().body(t);
  }

    public ResponseEntity<TaskList> DeleteTask(Integer id){
        TaskList task = taskRepository.findById(id).orElse(null);
        taskRepository.delete(task);
        return ResponseEntity.ok().body(task);
    }
}
