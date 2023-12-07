package b.softuni.surfApp.model.entity;

import b.softuni.surfApp.model.enums.DifficultyLevelEnum;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "camps")
public class CampEntity extends BaseEntity {

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    private LocalDateTime subscribeUntil;
    private Integer capacity;
    private DifficultyLevelEnum difficultyLevel;
    private String description;



    private Set<PictureEntity> pictures;
    private List<CommentEntityt> comments;
    private Set<EquipmentEntity> equipmentProvided;
    private Set<EquipmentEntity> equipmentNeeded;
    private UserEntity creator;
    private Set<UserEntity> participants;
    private Set<UserEntity> userLikes;
    private CampLocationEntity location;

    public CampEntity() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getSubscribeUntil() {
        return subscribeUntil;
    }

    public void setSubscribeUntil(LocalDateTime subscribeUntil) {
        this.subscribeUntil = subscribeUntil;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public DifficultyLevelEnum getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevelEnum difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<PictureEntity> getPictures() {
        return pictures;
    }

    public void setPictures(Set<PictureEntity> pictures) {
        this.pictures = pictures;
    }

    public List<CommentEntityt> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntityt> comments) {
        this.comments = comments;
    }

    public Set<EquipmentEntity> getEquipmentProvided() {
        return equipmentProvided;
    }

    public void setEquipmentProvided(Set<EquipmentEntity> equipmentProvided) {
        this.equipmentProvided = equipmentProvided;
    }

    public Set<EquipmentEntity> getEquipmentNeeded() {
        return equipmentNeeded;
    }

    public void setEquipmentNeeded(Set<EquipmentEntity> equipmentNeeded) {
        this.equipmentNeeded = equipmentNeeded;
    }

    public UserEntity getCreator() {
        return creator;
    }

    public void setCreator(UserEntity creator) {
        this.creator = creator;
    }

    public Set<UserEntity> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<UserEntity> participants) {
        this.participants = participants;
    }

    public Set<UserEntity> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(Set<UserEntity> userLikes) {
        this.userLikes = userLikes;
    }

    public CampLocationEntity getLocation() {
        return location;
    }

    public void setLocation(CampLocationEntity location) {
        this.location = location;
    }
}
