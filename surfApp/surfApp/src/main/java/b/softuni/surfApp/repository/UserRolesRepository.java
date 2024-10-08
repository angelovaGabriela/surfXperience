package b.softuni.surfApp.repository;

import b.softuni.surfApp.model.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoleEntity, Long> {

}
