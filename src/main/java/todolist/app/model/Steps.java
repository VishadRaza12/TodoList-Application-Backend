package todolist.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name= "STEPS")
@JsonIgnoreProperties(ignoreUnknown = true, value = { "hibernateLazyInitializer", "handler","task" }, allowSetters = true)
public class Steps {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STEP_ID")
    private Integer id;
    
    @Column(name = "TITLE", length = 250)
    private String title;

  
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "TASK_ID", referencedColumnName = "TASK_ID")
    private TaskList task;
}
