package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.UserService;
import kodlama.io.rentACar.business.requests.CreateUserRequest;
import kodlama.io.rentACar.business.requests.UpdateUserRequest;
import kodlama.io.rentACar.business.responses.GetAllUsersResponse;
import kodlama.io.rentACar.business.responses.GetByIdUserResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {

	private UserService userService;

	@GetMapping()
	public List<GetAllUsersResponse> getAll() {
		return userService.getAll();
	}

	@GetMapping("/{id}")
	public GetByIdUserResponse getById(@PathVariable int id) {
		return userService.getById(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateUserRequest createUserRequest) {
		this.userService.add(createUserRequest);
	}

	@PutMapping
	public void update(@RequestBody @Valid UpdateUserRequest updateUserRequest) {
		this.userService.update(updateUserRequest);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.userService.delete(id);
	}
}