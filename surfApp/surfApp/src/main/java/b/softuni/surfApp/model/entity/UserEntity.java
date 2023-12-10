package b.softuni.surfApp.model.entity;

import b.softuni.surfApp.model.enums.UserProfileEnum;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    private String username;
    private String password;
    private String email;

    private String firstName;
    private String lastName;
    private Integer age;

    private Double weightKg;
    private Double heightCm;

    private String about;
    private Boolean canParticipate;

    @Enumerated(EnumType.STRING)
    private UserProfileEnum userProfile;

    @OneToOne
    private PictureEntity profilePicture;

    @OneToMany
    private Set<StoryEntity> stories;

    @ManyToMany
    private Set<UserRoleEntity> userRoles;

    @OneToMany
    private Set<EquipmentEntity> equipmentProvided;

    @OneToMany
    private Set<EquipmentEntity> equipmentNeeded;

    @ManyToMany
    private Set<CampEntity> participated;

    @ManyToOne
    private CampEntity currentCamp;

    @ManyToMany
    private Set<CampEntity> likedCamps;

    @OneToMany
    private Set<CommentEntity> myComments;

    // created by me if I have a creator profile type
    @OneToMany
    private Set<CampEntity> myCamps;


    public UserEntity() {}

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(Double weightKg) {
        this.weightKg = weightKg;
    }

    public Double getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(Double heightCm) {
        this.heightCm = heightCm;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Boolean getCanParticipate() {
        return canParticipate;
    }

    public void setCanParticipate(Boolean canParticipate) {
        this.canParticipate = canParticipate;
    }

    public UserProfileEnum getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfileEnum userProfile) {
        this.userProfile = userProfile;
    }

    public PictureEntity getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(PictureEntity profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Set<StoryEntity> getStories() {
        return stories;
    }

    public void setStories(Set<StoryEntity> stories) {
        this.stories = stories;
    }

    public Set<UserRoleEntity> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRoleEntity> userRoles) {
        this.userRoles = userRoles;
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

    public CampEntity getCurrentCamp() {
        return currentCamp;
    }

    public void setCurrentCamp(CampEntity currentCamp) {
        this.currentCamp = currentCamp;
    }

    public Set<CampEntity> getParticipated() {
        return participated;
    }

    public void setParticipated(Set<CampEntity> participated) {
        this.participated = participated;
    }

    public Set<CampEntity> getLikedCamps() {
        return likedCamps;
    }

    public void setLikedCamps(Set<CampEntity> likedCamps) {
        this.likedCamps = likedCamps;
    }

    public Set<CommentEntity> getMyComments() {
        return myComments;
    }

    public void setMyComments(Set<CommentEntity> myComments) {
        this.myComments = myComments;
    }

    public Set<CampEntity> getMyCamps() {
        return myCamps;
    }

    public void setMyCamps(Set<CampEntity> myCamps) {
        this.myCamps = myCamps;
    }


}
