package b.softuni.surfApp.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Table(name = "stories")
public class Story extends BaseEntity {

    private LocalDate creationDate;


    private String storyText;

}
