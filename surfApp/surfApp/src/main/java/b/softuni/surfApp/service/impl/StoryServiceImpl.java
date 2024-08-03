package b.softuni.surfApp.service.impl;

import b.softuni.surfApp.model.binding.AddStoryBindingModel;
import b.softuni.surfApp.repository.StoryRepository;
import b.softuni.surfApp.service.StoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class StoryServiceImpl implements StoryService {

    private Logger LOGGER = LoggerFactory.getLogger(StoryServiceImpl.class);
    private final RestClient storyRestClient;
    private final StoryRepository storyRepository;

    public StoryServiceImpl(@Qualifier("storiesRestClient") RestClient storyRestClient,
                            StoryRepository storyRepository) {
        this.storyRestClient = storyRestClient;
        this.storyRepository = storyRepository;
    }


    @Override
    public void createStory(AddStoryBindingModel addStoryBindingModel) {
       LOGGER.debug("Create a new story..");

        storyRestClient
                .post()
                .uri("http://localhost:8081/stories")
                .body(addStoryBindingModel)
                .retrieve();
    }


    @Override
    public void deleteStory(long storyId) {
    storyRepository.deleteById(storyId);
    }
}
