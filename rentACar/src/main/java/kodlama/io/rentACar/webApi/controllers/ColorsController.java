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

import kodlama.io.rentACar.business.abstracts.ColorService;
import kodlama.io.rentACar.business.requests.CreateColorRequest;
import kodlama.io.rentACar.business.requests.UpdateColorRequest;
import kodlama.io.rentACar.business.responses.GetAllColorsResponse;
import kodlama.io.rentACar.business.responses.GetByIdColorResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/colors")
@AllArgsConstructor
public class ColorsController {

	ColorService colorService;

	@GetMapping()
	public List<GetAllColorsResponse> getAll() {
		return this.colorService.getAll();
	}

	@GetMapping("/{id}")
	public GetByIdColorResponse getById(@PathVariable int id) {
		return this.colorService.getById(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateColorRequest createColorRequest) {
		this.colorService.add(createColorRequest);
	}

	@PutMapping
	public void update(@RequestBody @Valid UpdateColorRequest updateColorRequest) {
		this.colorService.update(updateColorRequest);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.colorService.delete(id);
	}
}