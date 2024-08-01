package bg.softuni.surfApp.stories.repository;


import bg.softuni.surfApp.stories.model.entity.StoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends JpaRepository<StoryEntity,Long> {
}
