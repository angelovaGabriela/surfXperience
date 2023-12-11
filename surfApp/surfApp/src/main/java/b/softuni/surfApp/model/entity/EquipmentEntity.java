package b.softuni.surfApp.model.entity;

import b.softuni.surfApp.model.enums.EquipmentTypeEnum;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "equipments")
public class EquipmentEntity extends BaseEntity {

    @Column(name = "equipment_type", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private EquipmentTypeEnum equipmentType;

    @OneToOne
    private PictureEntity picture;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "have_it")
    private Boolean haveIt;

    @ManyToOne
    private UserEntity owner;

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

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentEntity that = (EquipmentEntity) o;
        return getEquipmentType() == that.getEquipmentType() && getHaveIt().equals(that.getHaveIt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEquipmentType(), getHaveIt());
    }
}
