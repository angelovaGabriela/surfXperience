package b.softuni.surfApp.model.entity;

import b.softuni.surfApp.model.enums.UserProfileEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "user_profile_type")
public class UserProfileType extends BaseEntity {

    @Column(name = "profile_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserProfileEnum profileType;

    public UserProfileType() {}

    public UserProfileEnum getProfileType() {
        return profileType;
    }

    public void setProfileType(UserProfileEnum profileType) {
        this.profileType = profileType;
    }
}
