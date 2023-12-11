package b.softuni.surfApp.repository;

import b.softuni.surfApp.model.entity.CampLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampLevelRepository extends JpaRepository<CampLevel, Long> {
}
