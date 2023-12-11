package b.softuni.surfApp.model.entity;

import b.softuni.surfApp.model.enums.DifficultyLevelEnum;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "camps")
public class CampEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "subscribe_until", nullable = false)
    private LocalDateTime subscribeUntil;

    @Column
    private Integer capacity;

    @ManyToOne(optional = false)
    private CampLevel level;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    @OneToMany
    private Set<PictureEntity> pictures;

    @OneToMany
    private Set<CommentEntity> comments;

    @OneToMany
    private Set<EquipmentEntity> equipmentProvided;

    @OneToMany
    private Set<EquipmentEntity> equipmentNeeded;

    @ManyToOne(optional = false)
    private UserEntity creator;

    @ManyToMany
    private Set<UserEntity> pastParticipants;

    @OneToMany
    private Set<UserEntity> currentParticipants;
    @ManyToMany
    private Set<UserEntity> userLikes;

    @ManyToOne
    private CampLocationEntity location;

    @OneToMany
    private Set<StoryEntity> stories;

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

    public Set<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(Set<CommentEntity> comments) {
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

    public Set<UserEntity> getCurrentParticipants() {
        return currentParticipants;
    }

    public void setCurrentParticipants(Set<UserEntity> currentParticipants) {
        this.currentParticipants = currentParticipants;
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

    public Set<UserEntity> getPastParticipants() {
        return pastParticipants;
    }

    public void setPastParticipants(Set<UserEntity> pastParticipants) {
        this.pastParticipants = pastParticipants;
    }

    public Set<StoryEntity> getStories() {
        return stories;
    }

    public void setStories(Set<StoryEntity> stories) {
        this.stories = stories;
    }

    public CampLevel getLevel() {
        return level;
    }

    public void setLevel(CampLevel level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CampEntity that = (CampEntity) o;
        return getName().equals(that.getName()) && getStartDate().equals(that.getStartDate()) && getEndDate().equals(that.getEndDate()) && getCreator().equals(that.getCreator());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getStartDate(), getEndDate(), getCreator());
    }

}
