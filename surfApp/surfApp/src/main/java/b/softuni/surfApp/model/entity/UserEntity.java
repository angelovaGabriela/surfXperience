package b.softuni.surfApp.model.entity;


import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Integer age;

    @Column(name = "wight_kg", nullable = false)
    private Double weightKg;

    @Column(name = "height_cm", nullable = false)
    private Double heightCm;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String about;

    @Column(name = "can_participate")
    private Boolean canParticipate;
    @OneToOne
    private PictureEntity profilePicture;

    @OneToMany
    private Set<StoryEntity> stories;

    @ManyToOne(optional = false)
    private UserProfileType profile;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private List<UserRoleEntity> roles;

    private boolean enabled;

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

    public List<UserRoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRoleEntity> roles) {
        this.roles = roles;
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

    public UserProfileType getProfile() {
        return profile;
    }

    public void setProfile(UserProfileType profile) {
        this.profile = profile;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return getUsername().equals(that.getUsername()) && getEmail().equals(that.getEmail());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getEmail());
    }
}
