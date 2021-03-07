package todolist.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import todolist.app.model.DateModel;

public interface DateModelRepository extends JpaRepository<DateModel,Integer> {
    
}
