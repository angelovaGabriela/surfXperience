package b.softuni.surfApp.model.entity;

import b.softuni.surfApp.model.enums.EquipmentTypeEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "equipments")
public class EquipmentEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private EquipmentTypeEnum equipmentType;

    private PictureEntity picture;

    private String description;

    private Boolean haveIt;

    public EquipmentEntity() {}

    public EquipmentTypeEnum getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentTypeEnum equipmentType) {
        this.equipmentType = equipmentType;
    }

    public PictureEntity getPicture() {
        return picture;
    }

    public void setPicture(PictureEntity picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getHaveIt() {
        return haveIt;
    }

    public void setHaveIt(Boolean haveIt) {
        this.haveIt = haveIt;
    }
}
