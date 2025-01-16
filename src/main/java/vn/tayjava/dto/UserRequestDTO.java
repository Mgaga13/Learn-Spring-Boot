package vn.tayjava.dto;

import static vn.tayjava.util.Gender.FEMALE;
import static vn.tayjava.util.Gender.MALE;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.springframework.format.annotation.DateTimeFormat;
import vn.tayjava.dto.validator.EnumPattern;
import vn.tayjava.util.Gender;
import vn.tayjava.dto.validator.EnumValue;
import vn.tayjava.dto.validator.GenderSubset;
import vn.tayjava.dto.validator.PhoneNumber;
import vn.tayjava.util.UserStatus;
import vn.tayjava.util.UserType;

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
//  @NotNull(message = "dateOfBirth must be not null")
//  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private Date dateOfBirth;
//  private LocalDate dateOfBirth;

  @NotNull(message = "username must be not null")
  private String username;

  @NotNull(message = "password must be not null")
  private String password;

  @NotEmpty(message = "addresses can not empty")
  private Set<Address> addresses;

  // Sử dụng được cho tất cả ENUM tiếp theo
  @EnumPattern(name = "status", regexp = "ACTIVE|INACTIVE|NONE")
  private UserStatus status;

  //Sử dung với các enum nhất định OTHER
  @GenderSubset(anyOf = {MALE, FEMALE})
  private Gender gender;


  @NotNull(message = "type must be not null")
  @EnumValue(name = "type", enumClass = UserType.class)
  private String type;


  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public UserRequestDTO(String firstName, String lastName, String email, String phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
  }

  public static class Address {

    private String apartmentNumber;
    private String floor;
    private String building;
    private String streetNumber;
    private String street;
    private String city;
    private String country;
    private Integer addressType;

    public String getApartmentNumber() {
      return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
      this.apartmentNumber = apartmentNumber;
    }

    public String getFloor() {
      return floor;
    }

    public void setFloor(String floor) {
      this.floor = floor;
    }

    public String getBuilding() {
      return building;
    }

    public void setBuilding(String building) {
      this.building = building;
    }

    public String getStreetNumber() {
      return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
      this.streetNumber = streetNumber;
    }

    public String getStreet() {
      return street;
    }

    public void setStreet(String street) {
      this.street = street;
    }

    public String getCity() {
      return city;
    }

    public void setCity(String city) {
      this.city = city;
    }

    public String getCountry() {
      return country;
    }

    public void setCountry(String country) {
      this.country = country;
    }

    public Integer getAddressType() {
      return addressType;
    }

    public void setAddressType(Integer addressType) {
      this.addressType = addressType;
    }
  }

  public UserStatus getStatus() {
    return status;
  }

  public void setStatus(UserStatus status) {
    this.status = status;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(Set<Address> addresses) {
    this.addresses = addresses;
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
