package b.softuni.surfApp.model.entity;

import b.softuni.surfApp.model.enums.DifficultyLevelEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "camp_levels")
public class CampLevel extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DifficultyLevelEnum name;

    public CampLevel() {}

    public DifficultyLevelEnum getName() {
        return name;
    }

    public void setName(DifficultyLevelEnum name) {
        this.name = name;
    }
}
