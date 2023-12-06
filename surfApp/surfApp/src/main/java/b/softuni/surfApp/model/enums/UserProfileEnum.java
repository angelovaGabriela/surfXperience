package b.softuni.surfApp.model.enums;

public enum UserProfileEnum {
    CAMP_CREATOR("Creator"),
    CAMP_COACH("Coach"),
    CAMP_PARTICIPANT("Participant");

    public final String label;

    private UserProfileEnum(String label) {
        this.label = label;
    }
}
