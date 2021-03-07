package todolist.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import todolist.app.model.Steps;

public interface StepsRepository extends JpaRepository<Steps, Integer>
{
    @Query("select t from Steps t where t.task.id=:id")
    List<Steps> findByTaskID(Integer id);
}
