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

import kodlama.io.rentACar.business.abstracts.RentalService;
import kodlama.io.rentACar.business.requests.CreateRentalRequest;
import kodlama.io.rentACar.business.requests.UpdateRentalRequest;
import kodlama.io.rentACar.business.responses.GetAllRentalsResponse;
import kodlama.io.rentACar.business.responses.GetByIdRentalResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/rentals")
@AllArgsConstructor
public class RentalsController {

	private RentalService rentalService;

	@GetMapping()
	public List<GetAllRentalsResponse> getAll() {
		return rentalService.getAll();
	}

	@GetMapping("/{id}")
	public GetByIdRentalResponse getById(@PathVariable int id) {
		return rentalService.getById(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateRentalRequest createRentalRequest) {
		this.rentalService.add(createRentalRequest);
	}

	@PutMapping
	public void update(@RequestBody @Valid UpdateRentalRequest updateRentalRequest) {
		this.rentalService.update(updateRentalRequest);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.rentalService.delete(id);
	}
}