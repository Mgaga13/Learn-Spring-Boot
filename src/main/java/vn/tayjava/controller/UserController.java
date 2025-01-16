package vn.tayjava.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import vn.tayjava.dto.UserRequestDTO;
import vn.tayjava.dto.response.ResponseSuccess;

@RestController
@Tag(name = "1. User Resource")
@RequestMapping("/user")
public class UserController {

  @PostMapping("/")
//  @RequestMapping(path = "/",method = RequestMethod.POST,headers = "apiKey=1.0")
  public ResponseSuccess addUser(// @RequestHeader("apiKey") String apiKey,
      @Valid @RequestBody UserRequestDTO user) {
    //System.out.println(apiKey);
    return new ResponseSuccess(HttpStatus.CREATED, "User added successfully",1);
  }

  @PutMapping("/{userId}")
  public ResponseSuccess updateUser(@PathVariable int userId, @RequestBody UserRequestDTO user) {
    System.out.println("User updated with id: " + userId);
    return new ResponseSuccess(HttpStatus.ACCEPTED,"User updated");
  }

  @PatchMapping("/{userId}")
  public ResponseSuccess changeUserStatus(
      @PathVariable @Min(value = 1, message = "userId must be greater than 0") int userId,
      @RequestParam int status) {
    System.out.println("User changed with id: " + userId + " status: " + status);
    return new ResponseSuccess(HttpStatus.ACCEPTED,"User changed status with REST method PATH ");
  }

  @DeleteMapping("/{userId}")
  public ResponseSuccess deleteUser(@Min(1) @PathVariable int userId) {
    return new ResponseSuccess(HttpStatus.NO_CONTENT,"User deleted with id: ");
  }

  @GetMapping("/{userId}")
  public ResponseSuccess getUser(@PathVariable int userId) {
    return new ResponseSuccess(HttpStatus.OK,"user",new UserRequestDTO("Tay", "Java", "admin@tayjava.vn", "0123456789"));
  }

  @GetMapping("list")
  @ResponseStatus(HttpStatus.OK)
  public ResponseSuccess getUsers(@RequestParam(required = false) String email,
      @RequestParam(defaultValue = "0") int pageNo,
      @RequestParam(defaultValue = "10") int pageSize) {
    System.out.println("request user ");
    return new ResponseSuccess(HttpStatus.OK,"list user",List.of(
        new UserRequestDTO("Giang", "Java", "giangnm@gmail,com", "0999999"),
        new UserRequestDTO("Chien", "Php", "chiennd@gmail,com", "08888888")));
  }
}
