package todolist.app.repository;

import java.util.List;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import todolist.app.model.TaskList;

@Repository
public interface TaskListRepository extends JpaRepository<TaskList, Integer>,
 DataTablesRepository<TaskList, Integer>
 {
     @Query("select t from TaskList t where t.important=1 ")
     List<TaskList> findByImportant();
     
     @Query("select count(t) from TaskList t where t.important=1")
     Integer findImportantCount();

     @Query("select t from TaskList t where t.completed=1 ")
     List<TaskList> findByCompleted();

    
}
