package b.softuni.surfApp.service.impl;

import b.softuni.surfApp.model.binding.UserRegisterBindingModel;
import b.softuni.surfApp.model.entity.UserEntity;
import b.softuni.surfApp.model.entity.UserProfileType;
import b.softuni.surfApp.repository.UserProfileRepository;
import b.softuni.surfApp.repository.UserRepository;
import b.softuni.surfApp.service.UserService;
import b.softuni.surfApp.user.SurfAppUserDetails;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserProfileRepository userProfileRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;


    private final UserDetailsService userDetailsService;


    public UserServiceImpl(UserProfileRepository userProfileRepository,
                           UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder,
                           UserDetailsService userDetailsService) {
        this.userProfileRepository = userProfileRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }


    @Override
    public void register(UserRegisterBindingModel userModel) {
        UserEntity user = modelMapper.map(userModel, UserEntity.class);
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));

        UserProfileType byProfileType = this.userProfileRepository.findByProfileType(userModel.getProfile());
        user.setProfile(byProfileType);

        this.userRepository.save(user);
//        login(user);

    }

    @Override
    public Optional<SurfAppUserDetails> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null
                && authentication.getPrincipal()
                instanceof SurfAppUserDetails surfAppUserDetails) {
            return Optional.of(surfAppUserDetails);
        }

        return Optional.empty();
    }

}
