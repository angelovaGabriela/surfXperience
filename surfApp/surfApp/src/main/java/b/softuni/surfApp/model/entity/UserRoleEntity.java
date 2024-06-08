package b.softuni.surfApp.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "roles")
public class UserRoleEntity extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users;
    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private List<PrivilegeEntity> privilegeEntities;



    public UserRoleEntity() {}

    public UserRoleEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public List<PrivilegeEntity> getPrivileges() {
        return privilegeEntities;
    }

    public void setPrivileges(List<PrivilegeEntity> privilegeEntities) {
        this.privilegeEntities = privilegeEntities;
    }
}
