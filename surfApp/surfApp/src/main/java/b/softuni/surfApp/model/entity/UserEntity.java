package b.softuni.surfApp.model.entity;

import b.softuni.surfApp.model.enums.UserProfileEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;


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




}
