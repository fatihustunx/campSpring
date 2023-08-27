package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateRentalRequest;
import kodlama.io.rentACar.business.requests.UpdateRentalRequest;
import kodlama.io.rentACar.business.responses.GetAllRentalsResponse;
import kodlama.io.rentACar.business.responses.GetByIdRentalResponse;

public interface RentalService {

	List<GetAllRentalsResponse> getAll();

	GetByIdRentalResponse getById(int id);

	void add(CreateRentalRequest createRentalRequest);

	void update(UpdateRentalRequest updateRentalRequest);

	void delete(int id);

}