package b.softuni.surfApp.model.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.util.*;

import static java.sql.Types.VARCHAR;


@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;

    @UUIDSequence
    @JdbcTypeCode(VARCHAR)
    private UUID uuid;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @ManyToMany(
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<UserRoleEntity> roles = new ArrayList<>();

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

    @ManyToOne(optional = false)
    private UserProfileType profile;


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

    public Integer getAge() {
        return age;
    }

    public UserEntity setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Boolean getCanParticipate() {
        return canParticipate;
    }

    public UserEntity setCanParticipate(Boolean canParticipate) {
        this.canParticipate = canParticipate;
        return this;
    }

    public CampEntity getCurrentCamp() {
        return currentCamp;
    }

    public UserEntity setCurrentCamp(CampEntity currentCamp) {
        this.currentCamp = currentCamp;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public UserEntity setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Set<EquipmentEntity> getEquipmentNeeded() {
        return equipmentNeeded;
    }

    public UserEntity setEquipmentNeeded(Set<EquipmentEntity> equipmentNeeded) {
        this.equipmentNeeded = equipmentNeeded;
        return this;
    }

    public Set<EquipmentEntity> getEquipmentProvided() {
        return equipmentProvided;
    }

    public UserEntity setEquipmentProvided(Set<EquipmentEntity> equipmentProvided) {
        this.equipmentProvided = equipmentProvided;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Double getHeightCm() {
        return heightCm;
    }

    public UserEntity setHeightCm(Double heightCm) {
        this.heightCm = heightCm;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Set<CampEntity> getLikedCamps() {
        return likedCamps;
    }

    public UserEntity setLikedCamps(Set<CampEntity> likedCamps) {
        this.likedCamps = likedCamps;
        return this;
    }

    public Set<CampEntity> getMyCamps() {
        return myCamps;
    }

    public UserEntity setMyCamps(Set<CampEntity> myCamps) {
        this.myCamps = myCamps;
        return this;
    }

    public Set<CommentEntity> getMyComments() {
        return myComments;
    }

    public UserEntity setMyComments(Set<CommentEntity> myComments) {
        this.myComments = myComments;
        return this;
    }

    public Set<CampEntity> getParticipated() {
        return participated;
    }

    public UserEntity setParticipated(Set<CampEntity> participated) {
        this.participated = participated;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserProfileType getProfile() {
        return profile;
    }

    public UserEntity setProfile(UserProfileType profile) {
        this.profile = profile;
        return this;
    }

    public PictureEntity getProfilePicture() {
        return profilePicture;
    }

    public UserEntity setProfilePicture(PictureEntity profilePicture) {
        this.profilePicture = profilePicture;
        return this;
    }

    public List<UserRoleEntity> getRoles() {
        return roles;
    }

    public UserEntity setRoles(List<UserRoleEntity> roles) {
        this.roles = roles;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public Double getWeightKg() {
        return weightKg;
    }

    public UserEntity setWeightKg(Double weightKg) {
        this.weightKg = weightKg;
        return this;
    }

    public String getAbout() {
        return about;
    }

    public UserEntity setAbout(String about) {
        this.about = about;
        return this;
    }

    public UUID getUuid() {
        return uuid;
    }

    public UserEntity setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
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
