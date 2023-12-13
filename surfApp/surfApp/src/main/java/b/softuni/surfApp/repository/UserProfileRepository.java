package b.softuni.surfApp.repository;

import b.softuni.surfApp.model.entity.UserProfileType;
import b.softuni.surfApp.model.enums.UserProfileEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfileType, Long> {
    UserProfileType findByProfileType(UserProfileEnum profile);
}
