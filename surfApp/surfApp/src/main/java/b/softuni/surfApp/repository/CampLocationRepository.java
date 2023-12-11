package b.softuni.surfApp.repository;

import b.softuni.surfApp.model.entity.CampLocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampLocationRepository extends JpaRepository<CampLocationEntity, Long> {
}
