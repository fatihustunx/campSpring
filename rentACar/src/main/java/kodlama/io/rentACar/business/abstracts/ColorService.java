package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateColorRequest;
import kodlama.io.rentACar.business.requests.UpdateColorRequest;
import kodlama.io.rentACar.business.responses.GetAllColorsResponse;
import kodlama.io.rentACar.business.responses.GetByIdColorResponse;

public interface ColorService {

	List<GetAllColorsResponse> getAll();
	
	GetByIdColorResponse getById(int id);
	
	void add(CreateColorRequest createColorRequest);
	
	void update(UpdateColorRequest updateColorRequest);
	
	void delete(int id);
}
