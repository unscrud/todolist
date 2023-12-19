package dev.unscrud.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;

    @PostMapping
    public void create(@RequestBody Task task, HttpServletRequest request){
        var idUser = request.getAttribute("idUser");
        System.out.println("Chegou no controller "+idUser);
        //this.taskRepository.save(task);
    }
}
