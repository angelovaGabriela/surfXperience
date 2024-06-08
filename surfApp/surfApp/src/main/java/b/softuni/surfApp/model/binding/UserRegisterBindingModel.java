package b.softuni.surfApp.model.binding;


import b.softuni.surfApp.model.enums.UserProfileEnum;
import b.softuni.surfApp.validations.FieldMatch;
import b.softuni.surfApp.validations.UniqueUserEmail;
import b.softuni.surfApp.validations.UniqueUsername;
import jakarta.validation.constraints.*;


@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords do not match!"
)
public class UserRegisterBindingModel {
    @NotBlank(message = "Username is required!")
    @Size(min = 5, max = 20, message = "Username should be between 5 and 20 characters.")
    @UniqueUsername(message = "The username is already taken!")
    private String username;

    @NotBlank(message = "First name is required!")
    @Size(min = 5, max = 20, message = "First name should be between 5 and 20 characters.")
    private String firstName;

    @NotBlank(message = "Last name is required!")
    @Size(min = 5, max = 20, message = "Last name should be between 5 and 20 characters.")
    private String lastName;

    @NotBlank(message = "E-mail is required!")
    @Email(message = "Must contain '@'!")
    @UniqueUserEmail(message = "An account with this e-mail already exists!")
    private String email;


    @NotNull(message = "Age is required!")
    @Positive(message = "Please, enter a positive number.")
    @Min(value = 10, message = "You must be at least 10 years old.")
    private Integer age;

    @NotNull(message = "Weight is required!")
    @Positive(message = "Please, enter a positive number.")
    private Double weightKg;

    @NotNull(message = "Height is required!")
    @Positive(message = "Please, enter a positive number.")
    private Double heightCm;

    @NotBlank(message = "Please, tell us more about yourself!")
    private String about;

    @NotNull
    private UserProfileEnum profile;

    @NotBlank(message = "Password is required!")
    @Size(min = 5, max = 20, message = "Password should be between 5 and 20 characters.")
    private String password;

    @NotBlank(message = "Password confirmation is required!")
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
