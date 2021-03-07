package todolist.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import todolist.app.model.TodoTask;

public interface TodoTaskRepository extends JpaRepository<TodoTask, Integer>
    {
}
