package kodlama.io.rentACar.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ModelBusinessRules {

	private ModelRepository modelRepository;

	public void checkIfModelNameExists(String name) {
		if (this.modelRepository.existsByName(name)) {
			throw new BusinessException("Model name already exists");

			// Check for a single brand !!
			// Check related request !

			// Java exception types !
		}
	}

	public void checkIfModelNameExists(int id, String name) {
		if (this.modelRepository.existsByBrandIdAndName(id, name)) {
			throw new BusinessException("Model name already exists !");
		}
	}
}
