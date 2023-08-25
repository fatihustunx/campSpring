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

import kodlama.io.rentACar.business.abstracts.AdminService;
import kodlama.io.rentACar.business.requests.CreateAdminRequest;
import kodlama.io.rentACar.business.requests.UpdateAdminRequest;
import kodlama.io.rentACar.business.responses.GetAllAdminsResponse;
import kodlama.io.rentACar.business.responses.GetByIdAdminResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/admins")
@AllArgsConstructor
public class AdminsControllers {

	private AdminService adminService;

	@GetMapping()
	public List<GetAllAdminsResponse> getAll() {
		return adminService.getAll();
	}

	@GetMapping("/{id}")
	public GetByIdAdminResponse getById(@PathVariable int id) {
		return adminService.getById(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateAdminRequest createAdminRequest) {
		this.adminService.add(createAdminRequest);
	}

	@PutMapping("/{id}")
	public void update(@RequestBody @Valid UpdateAdminRequest updateAdminRequest) {
		this.adminService.update(updateAdminRequest);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.adminService.delete(id);
	}
}
