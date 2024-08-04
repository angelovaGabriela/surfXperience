package b.softuni.surfApp.service.impl;

import b.softuni.surfApp.model.binding.AddStoryBindingModel;
import b.softuni.surfApp.model.view.FullStoryViewModel;
import b.softuni.surfApp.model.view.StoryViewModel;
import b.softuni.surfApp.repository.StoryRepository;
import b.softuni.surfApp.service.StoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class StoryServiceImpl implements StoryService {

    private final RestClient storiesRestClient;
    private Logger LOGGER = LoggerFactory.getLogger(StoryServiceImpl.class);
    private final RestClient storyRestClient;
    private final StoryRepository storyRepository;

    public StoryServiceImpl(@Qualifier("storiesRestClient") RestClient storyRestClient,
                            StoryRepository storyRepository, @Qualifier("storiesRestClient") RestClient storiesRestClient) {
        this.storyRestClient = storyRestClient;
        this.storyRepository = storyRepository;
        this.storiesRestClient = storiesRestClient;
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
    public List<StoryViewModel> getAllStories() {
        LOGGER.info("Get all stories...");

        return storiesRestClient
                .get()
                .uri("http://localhost:8081/stories")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(new ParameterizedTypeReference<>(){});
    }

    @Override
    public FullStoryViewModel fullStory(Long id) {
        return storiesRestClient
                .get()
                .uri("http://localhost:8081/stories/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(FullStoryViewModel.class);

    }


    @Override
    public void deleteStory(long storyId) {
    storyRepository.deleteById(storyId);
    }


}
