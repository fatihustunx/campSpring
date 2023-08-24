package kodlama.io.rentACar.business.rules;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import kodlama.io.rentACar.entities.conceretes.Car;
import kodlama.io.rentACar.entities.conceretes.enums.State;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarBusinessRules {

	CarRepository carRepository;

	public State checkState(String state) {
		State temp = returnState(state);
		if (temp != null) {
			return temp;
		} else {
			throw new BusinessException("State is not valid !");
		}
	}

	private State returnState(String state) {
		for (State s : State.values()) {
			if (s.toString().equals(state)) {
				String temp = state.toUpperCase(Locale.ENGLISH);
				State obj = State.valueOf(temp);
				return obj;
			}
		}
		return null;
	}

	public List<Car> checkGetAllParams(Optional<Integer> brandId, Optional<Integer> modelId,
			Optional<Integer> colorId) {
		List<Car> cars;
		if (brandId.isPresent() && modelId.isPresent() && colorId.isPresent()) {
			cars = carRepository.findByModelBrandIdAndModelIdAndColorId(brandId, modelId, colorId);
		} else if (brandId.isPresent() && modelId.isPresent()) {
			cars = carRepository.findByModelBrandIdAndModelId(brandId, modelId);
		} else if (brandId.isPresent() && colorId.isPresent()) {
			cars = carRepository.findByModelBrandIdAndColorId(brandId, colorId);
		} else if (modelId.isPresent() && colorId.isPresent()) {
			cars = carRepository.findByModelIdAndColorId(modelId, colorId);
		} else if (brandId.isPresent()) {
			cars = carRepository.findByModelBrandId(brandId);
		} else if (modelId.isPresent()) {
			cars = carRepository.findByModelId(modelId);
		} else if (colorId.isPresent()) {
			cars = carRepository.findByColorId(colorId);
		} else {
			cars = carRepository.findAll();
		}

		return cars;

	}
}