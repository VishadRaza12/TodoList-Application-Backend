package todolist.app.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import todolist.app.model.DateModel;
import todolist.app.model.Menu;
import todolist.app.model.TaskList;
import todolist.app.model.TodoTask;
import todolist.app.repository.MenuRepository;
import todolist.app.repository.TaskListRepository;
import todolist.app.service.TaskListService;

@Controller
@CrossOrigin(origins = { "${frontend.developmentUrl}" })
public class TaskListController {

    @Autowired
    private TaskListRepository taskRepository;

    @Autowired
    private TaskListService taskService;


    @Autowired
    private MenuRepository menuRepository;

    @PostMapping(value = "/api/task/save")
    public ResponseEntity<TaskList> saveTask(@Valid @RequestBody TaskList obj, HttpServletRequest objReq) throws URISyntaxException {
        TaskList result = taskService.saveTasks(obj);
   return ResponseEntity.created(new URI("/api/task/save/" + result.getId())).body(result);
    }

    // @GetMapping("/api/task/all")
    // public ResponseEntity<List<TaskList>> getAllTask() {

    //     return taskService.getAllTask();
    // }

    @GetMapping("/api/task/all/{key}")
    public ResponseEntity<List<TaskList>> getAllTask(@PathVariable(value = "key") String key) {
        Integer totalTask =  (int) taskRepository.count();
        Integer importantTask = taskRepository.findImportantCount();
      menuRepository.setTaskCount(totalTask, "Tasks");
      menuRepository.setTaskCount(importantTask, "Important");
if(key.equals("I")){
    return taskService.getImportantTask();
}
else if(key.equals("C")){
    return taskService.getCompletedTask();
}
else{
        return taskService.getAllTask();
}

    }

    

    @GetMapping("/api/sidemenu")
    public ResponseEntity<List<Menu>> getAllMenu(){
        return taskService.getAllMenu();
    }

    @GetMapping("/api/dates")
    public ResponseEntity<List<DateModel>> getAllDatesModel(){
        return taskService.getAllDatesModel();
    }

    @GetMapping("/api/task/{id}")
    @ResponseBody
    public ResponseEntity<TaskList> getTaskByID(@PathVariable(value = "id") int Id) {

        return taskService.getById(Id);
    }

 

    @DeleteMapping("/api/task/{id}")
    @ResponseBody
    public ResponseEntity<TaskList> deleteTask(@PathVariable(value = "id") int Id) {

        return taskService.DeleteTask(Id);
    }

  


    @ResponseBody
    @PostMapping(value="/api/tasktable")
    public DataTablesOutput<TaskList> ListDataTable(@RequestBody DataTablesInput  input) {
        DataTablesOutput<TaskList> usersTest = taskRepository.findAll(input);

     return usersTest;
 }
}