package todolist.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import todolist.app.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    
    @Transactional
    @Modifying
    @Query("update Menu  m set m.count=:totalTask where m.key=:task ")
    public void setTaskCount(Integer totalTask, String task);

   
}
