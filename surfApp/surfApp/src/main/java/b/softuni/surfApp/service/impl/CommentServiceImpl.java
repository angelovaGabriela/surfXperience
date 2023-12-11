package b.softuni.surfApp.service.impl;

import b.softuni.surfApp.model.entity.CommentMood;
import b.softuni.surfApp.model.entity.UserProfileType;
import b.softuni.surfApp.model.enums.MoodEnum;
import b.softuni.surfApp.repository.CommentMoodRepository;
import b.softuni.surfApp.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentMoodRepository commentMoodRepository;

    public CommentServiceImpl(CommentMoodRepository commentMoodRepository) {
        this.commentMoodRepository = commentMoodRepository;
    }

    @Override
    public void initCommentMoods() {
        if (this.commentMoodRepository.count() == 0) {
            Arrays.stream(MoodEnum.values())
                    .forEach(mood -> {
                        CommentMood commentMood = new CommentMood();
                        commentMood.setMood(mood);
                        this.commentMoodRepository.save(commentMood);
                    });
        }
    }
}
