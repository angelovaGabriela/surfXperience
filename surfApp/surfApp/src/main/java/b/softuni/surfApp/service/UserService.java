package b.softuni.surfApp.service;

import b.softuni.surfApp.model.binding.UserRegisterBindingModel;

public interface UserService {

    void initProfiles();

    void register(UserRegisterBindingModel userModel);


}
