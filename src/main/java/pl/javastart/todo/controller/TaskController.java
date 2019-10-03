package pl.javastart.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.todo.entity.Task;
import pl.javastart.todo.entity.TaskComplited;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) TaskComplited complited) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Task> query;

//        if(taskTerm==null){
//            query = entityManager.createQuery("SELECT t from Task t ORDER BY t.task_term ASC ", Task.class);
//        }

        if (complited == null) {
            query = entityManager.createQuery("SELECT t from Task t", Task.class);
        } else {
            query = entityManager.createQuery("SELECT t from Task t WHERE t.complited = '" + complited + "'", Task.class);
        }

        List<Task> tasks = query.getResultList();
        model.addAttribute("tasks", tasks);
        model.addAttribute("taskToDo", new Task());


        return "home";
    }

    @GetMapping("/zadanie")
    public String taskInfo(@RequestParam long id, Model model) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Task task = entityManager.find(Task.class, id);
        model.addAttribute("task", task);

        return "taskinfo";
    }

    @PostMapping("/add")
    public String addTask(Task task) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(task);
        entityManager.getTransaction().commit();
        return "redirect:/";
    }
}
