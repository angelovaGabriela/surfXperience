package bg.softuni.surfApp.stories.service.impl;

import bg.softuni.surfApp.stories.model.binding.AddStoryBindingModel;
import bg.softuni.surfApp.stories.model.binding.StoryBindingModel;
import bg.softuni.surfApp.stories.model.entity.StoryEntity;
import bg.softuni.surfApp.stories.repository.StoryRepository;
import bg.softuni.surfApp.stories.service.StoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StoryServiceImpl implements StoryService {

    private final StoryRepository storyRepository;


    public StoryServiceImpl(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }


    @Override
    public void createStory(AddStoryBindingModel addStoryBindingModel) {
        this.storyRepository.save(map(addStoryBindingModel));
    }

    @Override
    public void deleteStory(Long storyId) {
        storyRepository.deleteById(storyId);
    }

    @Override
    public List<StoryBindingModel> getAllStories() {
        return storyRepository.findAll()
                .stream()
                .map(StoryServiceImpl::map)
                .toList();
    }

    @Override
    public StoryBindingModel getStory(Long id) {
        return storyRepository.findById(id)
                .map(StoryServiceImpl::map)
                .orElseThrow(()->new IllegalArgumentException("Not found story!"));
    }


    private static StoryBindingModel map(StoryEntity storyEntity) {

        StoryBindingModel story = new StoryBindingModel();
        story.setId(storyEntity.getId());
        story.setTitle(storyEntity.getTitle());
        story.setCreationMoment(storyEntity.getCreationMoment());
        story.setStoryText(storyEntity.getStoryText());
        story.setAuthorName(storyEntity.getAuthorName());
        story.setCampName(storyEntity.getCampName());
        story.setOriginalLanguage(storyEntity.getOriginalLanguage());



        return story;

    }


    private static StoryEntity map(AddStoryBindingModel addStoryBindingModel) {

                StoryEntity story = new StoryEntity();
                story.setCreationMoment(LocalDateTime.now());
                story.setStoryText(addStoryBindingModel.getStoryText());
                story.setAuthorName("Милена");
                story.setTitle(addStoryBindingModel.getTitle());
                story.setCampName("Сърф в Австралия");
                story.setOriginalLanguage(language(addStoryBindingModel))

       ;


        return story;

    }

    private static String language(AddStoryBindingModel addStoryBindingModel) {
        String language = "";
        if (addStoryBindingModel.getStoryText().contains("g")){
            language = "en";
        } else if (addStoryBindingModel.getStoryText().contains("г")) {
            language = "bg";
        }

        return language;
    }
}
