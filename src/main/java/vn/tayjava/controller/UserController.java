package vn.tayjava.controller;


import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
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
import vn.tayjava.configuration.Translator;
import vn.tayjava.dto.request.UserRequestDTO;
import vn.tayjava.dto.response.ResponseData;
import vn.tayjava.dto.response.ResponseFailure;
import vn.tayjava.dto.response.ResponseSuccess;

@RestController
@RequestMapping("/user")
@Validated
@Slf4j
@Tag(name = "User Controller")
public class UserController {

  @Operation(method = "POST", summary = "Add new user", description = "Send a request via this API to create new user")
  @PostMapping(value = "/")
  public ResponseData<Integer> addUser(@Valid @RequestBody UserRequestDTO user) {
    log.info("Request add user, {} {}", user.getFirstName(), user.getLastName());
    return new ResponseData<>(HttpStatus.CREATED.value(), Translator.toLocale("user.add.success"), 1);
  }

  @Operation(summary = "Update user", description = "Send a request via this API to update user")
  @PutMapping("/{userId}")
  public ResponseData<?> updateUser(@PathVariable @Min(1) int userId, @Valid @RequestBody UserRequestDTO user) {
    log.info("Request update userId={}", userId);
    return new ResponseData<>(HttpStatus.ACCEPTED.value(), Translator.toLocale("user.upd.success"));
  }

  @Operation(summary = "Change status of user", description = "Send a request via this API to change status of user")
  @PatchMapping("/{userId}")
  public ResponseData<?> updateStatus(@Min(1) @PathVariable int userId, @RequestParam boolean status) {
    log.info("Request change status, userId={}", userId);
    return new ResponseData<>(HttpStatus.ACCEPTED.value(), Translator.toLocale("user.change.success"));
  }

  @Operation(summary = "Delete user permanently", description = "Send a request via this API to delete user permanently")
  @DeleteMapping("/{userId}")
  public ResponseSuccess deleteUser(@Min(1) @PathVariable int userId) {
    return new ResponseSuccess(HttpStatus.NO_CONTENT, "User deleted with id: ");
  }

  @Operation(summary = "Get user detail", description = "Send a request via this API to get user information")
  @GetMapping("/{userId}")
  public ResponseSuccess getUser(@PathVariable int userId) {
    return new ResponseSuccess(HttpStatus.OK, "user",
        new UserRequestDTO("Tay", "Java", "admin@tayjava.vn", "0123456789"));
  }

  @Operation(summary = "Get list of users per pageNo", description = "Send a request via this API to get user list by pageNo and pageSize")
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
