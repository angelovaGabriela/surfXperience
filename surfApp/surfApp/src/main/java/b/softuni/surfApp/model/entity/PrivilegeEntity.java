package b.softuni.surfApp.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "privileges")
public class PrivilegeEntity extends BaseEntity {

        private String name;

        @ManyToMany(mappedBy = "privilegeEntities")
        private List<UserRoleEntity> roles;

    public PrivilegeEntity() {}

    public PrivilegeEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserRoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRoleEntity> roles) {
        this.roles = roles;
    }
}
