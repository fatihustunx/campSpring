package kodlama.io.rentACar.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ModelBusinessRules {

	private ModelRepository modelRepository;

	public void checkIfModelNameExists(String name) {
		if (this.modelRepository.existsByName(name)) {
			throw new RuntimeException("Model name already exists");

			// Check for a single brand !!

			// Java exception types !
		}
	}
}