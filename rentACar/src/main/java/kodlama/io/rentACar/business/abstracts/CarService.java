package kodlama.io.rentACar.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.requests.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.GetAllCarsResponse;
import kodlama.io.rentACar.business.responses.GetByIdCarResponse;

public interface CarService {

	List<GetAllCarsResponse> getAll(Optional<Integer> brandId, Optional<Integer> modelId, Optional<Integer> colorId);

	GetByIdCarResponse getById(int id);

	void add(CreateCarRequest createCarRequest);

	void update(UpdateCarRequest updateCarRequest);

	void delete(int id);

}