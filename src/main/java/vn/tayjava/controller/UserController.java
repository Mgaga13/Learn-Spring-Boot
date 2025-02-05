package vn.tayjava.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import vn.tayjava.dto.response.ResponseData;
import vn.tayjava.dto.response.ResponseFailure;
import vn.tayjava.dto.response.ResponseSuccess;

@RestController
@Tag(name = "1. User Resource")
@RequestMapping("/user")
public class UserController {

//  @Operation(summary = "Create user", description = "Create user", responses = {
//      @ApiResponse(
//          responseCode = "201",
//          description = "user added successfully",
//          content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, examples = @ExampleObject(
//              name = "ex name",
//              summary = "ex summary",
//              value = """
//                  {
//                      "status": 201,
//                      "message": "User added successfully",
//                      "data": 1
//                  }
//                  """
//          )
//          )
//      )
//  })
  @PostMapping("/")
//  @RequestMapping(path = "/",method = RequestMethod.POST,headers = "apiKey=1.0")
  public ResponseSuccess addUser(// @RequestHeader("apiKey") String apiKey,
      @Valid @RequestBody UserRequestDTO user) {
    System.out.println("Request add user " + user.getFirstName());

    try {
      return new ResponseSuccess(HttpStatus.CREATED, "User added successfully", 1);
    } catch (Exception e) {
      return new ResponseFailure(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }


  @PutMapping("/{userId}")
  public ResponseSuccess updateUser(@PathVariable @Min(1) int userId, @Valid @RequestBody UserRequestDTO user) {
    System.out.println("Request update userId=" + userId);

    try {
      return new ResponseSuccess(HttpStatus.ACCEPTED, "User updated successfully");
    } catch (Exception e) {
      return new ResponseFailure(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @PatchMapping("/{userId}")
  public ResponseSuccess changeUserStatus(
      @PathVariable @Min(value = 1, message = "userId must be greater than 0") int userId,
      @RequestParam int status) {
    System.out.println("User changed with id: " + userId + " status: " + status);
    return new ResponseSuccess(HttpStatus.ACCEPTED, "User changed status with REST method PATH ");
  }

  @DeleteMapping("/{userId}")
  public ResponseSuccess deleteUser(@Min(1) @PathVariable int userId) {
    return new ResponseSuccess(HttpStatus.NO_CONTENT, "User deleted with id: ");
  }

  @GetMapping("/{userId}")
  public ResponseSuccess getUser(@PathVariable int userId) {
    return new ResponseSuccess(HttpStatus.OK, "user",
        new UserRequestDTO("Tay", "Java", "admin@tayjava.vn", "0123456789"));
  }

  @GetMapping("list")
  @ResponseStatus(HttpStatus.OK)
  public ResponseData<List<UserRequestDTO>> getUsers(@RequestParam(required = false) String email,
      @RequestParam(defaultValue = "0") int pageNo,
      @RequestParam(defaultValue = "10") int pageSize) {
    System.out.println("request user ");
    return new ResponseData(HttpStatus.OK.value(), "list user", List.of(
        new UserRequestDTO("Giang", "Java", "giangnm@gmail,com", "0999999"),
        new UserRequestDTO("Chien", "Php", "chiennd@gmail,com", "08888888")));
  }
}
