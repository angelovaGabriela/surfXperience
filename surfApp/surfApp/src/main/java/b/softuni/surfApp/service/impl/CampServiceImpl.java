package b.softuni.surfApp.service.impl;

import b.softuni.surfApp.model.entity.CampLevel;
import b.softuni.surfApp.model.enums.DifficultyLevelEnum;
import b.softuni.surfApp.repository.CampLevelRepository;
import b.softuni.surfApp.service.CampService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CampServiceImpl implements CampService {
    private final CampLevelRepository campLevelRepository;

    public CampServiceImpl(CampLevelRepository campLevelRepository) {
        this.campLevelRepository = campLevelRepository;
    }
    @Override
    public void initCampLevels() {
        if (this.campLevelRepository.count() == 0) {
            Arrays.stream(DifficultyLevelEnum.values())
                    .forEach(difficulty -> {
                        CampLevel level = new CampLevel();
                        level.setName(difficulty);
                        this.campLevelRepository.save(level);
                    });
        }
    }
}
