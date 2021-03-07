package todolist.app.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import todolist.app.bean.StepTaskPOJO;
import todolist.app.model.Steps;
import todolist.app.service.StepsService;

@Controller
public class StepsController {
    
    @Autowired
    private StepsService stepsService;

    
    @PostMapping(value = "/api/step")
    public ResponseEntity<Steps> saveTask(@Valid @RequestBody StepTaskPOJO obj, HttpServletRequest objReq) throws URISyntaxException {
        Steps result = stepsService.saveSteps(obj);
   return ResponseEntity.created(new URI("/api/step/" + result.getId())).body(result);
    }

    @GetMapping("/api/step/{id}")
    @ResponseBody
    public ResponseEntity<List<Steps>> getTaskByID(@PathVariable(value = "id") int Id) {

        return stepsService.getByTaskId(Id);
    }

    @DeleteMapping("/api/step/{id}")
    @ResponseBody
    public ResponseEntity<Steps> deleteTodoTask(@PathVariable(value = "id") int Id) {

        return stepsService.DeleteTask(Id);
    }



    
}
