package b.softuni.surfApp.model.binding;


import b.softuni.surfApp.model.enums.UserProfileEnum;
import b.softuni.surfApp.validations.FieldMatch;
import b.softuni.surfApp.validations.UniqueUserEmail;
import b.softuni.surfApp.validations.UniqueUsername;
import jakarta.validation.constraints.*;


@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "{passwords}"
)
public class UserRegisterBindingModel {
    @NotBlank(message = "{username_empty}")
    @Size(min = 5, max = 20, message = "{username_size}")
    @UniqueUsername(message = "{username_unique}")
    private String username;

    @NotBlank(message = "{first_name_empty}")
    @Size(min = 5, max = 20, message = "{first_name_size}")
    private String firstName;

    @NotBlank(message = "{last_name_empty}")
    @Size(min = 5, max = 20, message = "{last_name_size}")
    private String lastName;

    @NotBlank(message = "{email_empty}")
    @Email(message = "{email_rule}")
    @UniqueUserEmail(message = "{email_unique}")
    private String email;


    @NotNull(message ="{age_empty}")
    @Positive(message = "{age_negative}")
    @Min(value = 10, message = "{age_too_young}")
    private Integer age;

    @NotNull(message = "{weight_empty}")
    @Positive(message = "{weight_negative}")
    private Double weightKg;

    @NotNull(message = "{height_empty}")
    @Positive(message = "{height_negative}")
    private Double heightCm;

    @NotBlank(message = "{about}")
    private String about;

    @NotNull
    private UserProfileEnum profile;

    @NotBlank(message = "{password_empty}")
    @Size(min = 5, max = 20, message = "{password_size}")
    private String password;

    @NotBlank(message = "{password_confirm_empty}")
    private String confirmPassword;

    public UserRegisterBindingModel() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(Double weightKg) {
        this.weightKg = weightKg;
    }

    public Double getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(Double heightCm) {
        this.heightCm = heightCm;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public UserProfileEnum getProfile() {
        return profile;
    }

    public void setProfile(UserProfileEnum profile) {
        this.profile = profile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
