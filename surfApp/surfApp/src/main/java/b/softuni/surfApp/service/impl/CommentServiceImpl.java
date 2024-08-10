package b.softuni.surfApp.service.impl;

import b.softuni.surfApp.repository.CommentMoodRepository;
import b.softuni.surfApp.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentMoodRepository commentMoodRepository;

    public CommentServiceImpl(CommentMoodRepository commentMoodRepository) {
        this.commentMoodRepository = commentMoodRepository;
    }

}
