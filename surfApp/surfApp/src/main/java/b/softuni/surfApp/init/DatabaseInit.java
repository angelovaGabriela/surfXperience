package b.softuni.surfApp.init;

import b.softuni.surfApp.service.CampService;
import b.softuni.surfApp.service.CommentService;
import b.softuni.surfApp.service.EquipmentService;
import b.softuni.surfApp.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final UserService userService;
    private final CommentService commentService;
    private final EquipmentService equipmentService;
    private final CampService campService;

    public DatabaseInit(UserService userService,
                        CommentService commentService,
                        EquipmentService equipmentService,
                        CampService campService) {
        this.userService = userService;
        this.commentService = commentService;
        this.equipmentService = equipmentService;
        this.campService = campService;
    }

    @Override
    public void run(String... args) throws Exception {
        userService.initProfiles();
        commentService.initCommentMoods();
        equipmentService.initEquipmentTypes();
//        campService.initCampLevels();
    }
}
