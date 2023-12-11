package b.softuni.surfApp.repository;

import b.softuni.surfApp.model.entity.CampEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampRepository extends JpaRepository<CampEntity, Long> {

}
