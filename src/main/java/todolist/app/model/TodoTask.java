package todolist.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



import lombok.NoArgsConstructor;




@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name= "Task")
public class TodoTask {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TASK_ID")
    private Integer id;
    
    @Column(name = "TITLE", length = 250)
    private String title; 
}
