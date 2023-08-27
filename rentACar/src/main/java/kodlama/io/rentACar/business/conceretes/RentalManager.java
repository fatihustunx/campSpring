package kodlama.io.rentACar.business.conceretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.RentalService;
import kodlama.io.rentACar.business.requests.CreateRentalRequest;
import kodlama.io.rentACar.business.requests.UpdateRentalRequest;
import kodlama.io.rentACar.business.responses.GetAllRentalsResponse;
import kodlama.io.rentACar.business.responses.GetByIdRentalResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.RentalRepository;
import kodlama.io.rentACar.entities.conceretes.Rental;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {

	private RentalRepository rentalRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllRentalsResponse> getAll() {
		List<Rental> rentals = rentalRepository.findAll();
		List<GetAllRentalsResponse> rentalsResponse = rentals.stream()
				.map(rental -> modelMapperService.forResponse().map(rental, GetAllRentalsResponse.class))
				.collect(Collectors.toList());

		return rentalsResponse;
	}

	@Override
	public GetByIdRentalResponse getById(int id) {
		Rental rental = rentalRepository.findById(id).orElseThrow();
		GetByIdRentalResponse rentalResponse = modelMapperService.forResponse().map(rental,
				GetByIdRentalResponse.class);

		return rentalResponse;
	}

	@Override
	public void add(CreateRentalRequest createRentalRequest) {
		Rental rental = modelMapperService.forRequest().map(createRentalRequest, Rental.class);

		rentalRepository.save(rental);

	}

	@Override
	public void update(UpdateRentalRequest updateRentalRequest) {
		Rental rental = modelMapperService.forRequest().map(updateRentalRequest, Rental.class);

		rentalRepository.save(rental);
	}

	@Override
	public void delete(int id) {
		this.rentalRepository.deleteById(id);
	}
}