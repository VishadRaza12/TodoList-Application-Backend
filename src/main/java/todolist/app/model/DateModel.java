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


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name= "DATEMODEL")
public class DateModel {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DATE_ID")
    private Integer id;
    
    @Column(name = "TITLE", length = 250)
    private String title;

    @Column(name= "DATE_KEY")
    private String key;

}
