package b.softuni.surfApp.model.entity;


import b.softuni.surfApp.model.enums.EquipmentTypeEnum;

import javax.persistence.*;

@Entity
@Table(name = "equipment_types")
public class EquipmentType extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private EquipmentTypeEnum name;

    public EquipmentType() {}

    public EquipmentTypeEnum getName() {
        return name;
    }

    public void setName(EquipmentTypeEnum name) {
        this.name = name;
    }
}
