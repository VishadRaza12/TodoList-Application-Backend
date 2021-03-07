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
@Table(name= "MENU")
public class Menu {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MENU_ID")
    private Integer id;
    
    @Column(name = "TITLE", length = 250)
    private String title;

    @Column(name= "MENU_KEY")
    private String key;

    @Column(name="COUNT")
    private Integer count;
}
