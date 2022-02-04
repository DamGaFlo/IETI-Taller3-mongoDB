package co.edu.escuelaing.ieti.lvl2api.dto;

public class UserDto{
    private String name;
    private String email;
    private String lastName;

    public UserDto(String name, String email, String lastName) {
        this.name = name;
        this.email = email;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }
}