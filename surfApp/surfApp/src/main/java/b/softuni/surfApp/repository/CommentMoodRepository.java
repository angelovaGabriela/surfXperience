package b.softuni.surfApp.repository;

import b.softuni.surfApp.model.entity.CommentMood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentMoodRepository extends JpaRepository<CommentMood, Long> {
}
