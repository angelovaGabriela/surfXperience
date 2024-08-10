package b.softuni.surfApp.service;

import b.softuni.surfApp.model.binding.UserRegisterBindingModel;
import b.softuni.surfApp.user.SurfAppUserDetails;

import java.util.Optional;

public interface UserService {

    void register(UserRegisterBindingModel userModel);

   Optional<SurfAppUserDetails> getCurrentUser();

}
