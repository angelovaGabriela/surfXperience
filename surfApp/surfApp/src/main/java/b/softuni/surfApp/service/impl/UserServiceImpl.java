package b.softuni.surfApp.service.impl;

import b.softuni.surfApp.model.entity.UserEntity;
import b.softuni.surfApp.model.entity.UserProfileType;
import b.softuni.surfApp.model.enums.UserProfileEnum;
import b.softuni.surfApp.repository.UserProfileRepository;
import b.softuni.surfApp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private final UserProfileRepository userProfileRepository;

    public UserServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public void initProfiles() {

        if (this.userProfileRepository.count() == 0) {
            Arrays.stream(UserProfileEnum.values())
                    .forEach(userProfile -> {
                        UserProfileType profile = new UserProfileType();
                        profile.setProfileType(userProfile);
                        this.userProfileRepository.save(profile);
                    });
        }
    }
}
