package todolist.app.model;

import java.util.ArrayList;
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
@Table(name= "TaskList")
public class TaskList {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TASK_ID")
    private Integer id;
    
    @Column(name = "TITLE", length = 250)
    private String title;
    
    @Column(name = "DUEDATE")
    private Date dueDate;

    @Column(name = "CREATEDON")
    private Date createdOn;
    
    @Column(name= "ATTACHMENT")
    private String attachment;

    @Column(name = "_IMPORTANT")
    private boolean important;

    @Column(name = "_COMPLETED")
    private boolean completed;

 }
