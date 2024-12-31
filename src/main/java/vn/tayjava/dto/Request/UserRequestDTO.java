package vn.tayjava.dto.Request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import vn.tayjava.util.PhoneNumber;

public class UserRequestDTO implements Serializable {

  @NotBlank(message = "firstName must be not Blank")
  private String firstName;

  @NotNull(message = "lastName must be not null")
  private String lastName;
  @Email(message = "email invalid format")
  private String email;
//  @Pattern(regexp = "^\\d{10}$", message = "phone invalid format")
  @PhoneNumber
  private String phone;

  @NotNull(message = "dateOfBirth not null")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  @JsonFormat(pattern = "MM/dd/yyyy")
  private Date dateOfBirth;
//  private LocalDate dateOfBirth;

  @NotEmpty(message = "permission not empty")
  private List<String> permission;

  public UserRequestDTO(String firstName, String lastName, String email, String phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
  }

  public List<String> getPermission() {
    return permission;
  }

  public void setPermission(List<String> permission) {
    this.permission = permission;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }
}
