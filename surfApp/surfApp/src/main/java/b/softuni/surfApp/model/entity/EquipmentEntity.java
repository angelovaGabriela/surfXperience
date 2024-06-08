package b.softuni.surfApp.model.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "equipments")
public class EquipmentEntity extends BaseEntity {
    @ManyToOne(optional = false)
    private EquipmentType type;
    @OneToOne
    private PictureEntity picture;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "have_it")
    private Boolean haveIt;

    @ManyToOne
    private UserEntity owner;

    public EquipmentEntity() {}

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


    public EquipmentType getType() {
        return type;
    }

    public void setType(EquipmentType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentEntity that = (EquipmentEntity) o;
        return getType().equals(that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType());
    }
}
