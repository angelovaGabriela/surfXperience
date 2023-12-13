package b.softuni.surfApp.model.binding;


import b.softuni.surfApp.model.entity.UserProfileType;
import b.softuni.surfApp.validations.FieldMatch;
import b.softuni.surfApp.validations.UniqueUserEmail;
import b.softuni.surfApp.validations.UniqueUsername;


import javax.validation.constraints.*;


@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords do not match!"
)
public class UserRegisterBindingModel {

    @NotBlank(message = "Username must be provided!")
    @Size(min = 5, max = 20)
    @UniqueUsername(message = "Username must be unique!")
    private String username;

    @NotBlank(message = "First name must be provided!")
    @Size(min = 5, max = 20)
    private String firstName;

    @NotBlank(message = "Last name must be provided!")
    @Size(min = 5, max = 20)
    private String lastName;

    @NotBlank(message = "E-mail must be provided!")
    @Email(message = "E-mail must be valid: example@example.com!")
    @UniqueUserEmail(message = "E-mail must be unique!")
    private String email;

    @NotBlank(message = "Age must be provided!")
    @Positive
    @Min(10)
    private Integer age;

    @NotBlank(message = "Weight must be provided!")
    @Positive
    private Double weightKg;

    @NotBlank(message = "Height must be provided!")
    @Positive
    private Double heightCm;

    @NotBlank(message = "Tell us about yourself!")
    private String about;

    @NotNull(message = "The field is mandatory!")
    private UserProfileType profile;

    @NotBlank(message = "The field is mandatory!")
    @Size(min = 5, max = 20)
    private String password;

    @NotBlank(message = "The field is mandatory!")
    @Size(min = 5, max = 20)
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

    public UserProfileType getProfile() {
        return profile;
    }

    public void setProfile(UserProfileType profile) {
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
