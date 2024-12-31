package vn.tayjava.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.tayjava.dto.Request.UserRequestDTO;

@RestController
@Tag(name = "1. User Resource")
@RequestMapping("/user")
public class UserController {

//  @PostMapping("/")
  @RequestMapping(path = "/",method = RequestMethod.POST,headers = "apiKey=1.0")
  public String addUser(@RequestHeader("apiKey") String apiKey,@RequestBody UserRequestDTO user) {
    System.out.println(apiKey);
    return "User added";
  }

  @PutMapping("/{userId}")
  public String updateUser(@PathVariable int userId, @RequestBody UserRequestDTO user) {
    System.out.println("User updated with id: " + userId);
    return "User updated";
  }

  @PatchMapping("/{userId}")
  public String changeUserStatus(@PathVariable int userId, @RequestParam boolean status) {
    System.out.println("User changed with id: " + userId + " status: " + status);
    return "User changed status with REST method PATH ";
  }

  @DeleteMapping("/{userId}")
  public String deleteUser(@PathVariable int userId) {
    return "User deleted";
  }

  @GetMapping("/{userId}")
  public UserRequestDTO getUser(@PathVariable int userId) {
    return new UserRequestDTO("Tay", "Java", "admin@tayjava.vn", "0123456789");
  }

  @GetMapping("list")
  public List<UserRequestDTO> getUsers(@RequestParam(required = false) String email,
      @RequestParam(defaultValue = "0") int pageNo,
      @RequestParam(defaultValue = "10") int pageSize) {
    System.out.println("request user ");
    return List.of(
        new UserRequestDTO("Giang", "Java", "giangnm@gmail,com", "0999999"),
        new UserRequestDTO("Chien", "Php", "chiennd@gmail,com", "08888888"));
  }
}
