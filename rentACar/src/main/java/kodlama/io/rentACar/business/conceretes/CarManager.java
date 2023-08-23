package kodlama.io.rentACar.business.conceretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.requests.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.GetAllCarsResponse;
import kodlama.io.rentACar.business.responses.GetByIdCarResponse;
import kodlama.io.rentACar.business.rules.CarBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import kodlama.io.rentACar.entities.conceretes.Car;
import kodlama.io.rentACar.entities.conceretes.enums.State;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

	CarRepository carRepository;
	ModelMapperService modelMapperService;
	CarBusinessRules carBusinessRules;

	@Override
	public List<GetAllCarsResponse> getAll() {
		List<Car> cars = carRepository.findAll();
		List<GetAllCarsResponse> carsResponse = cars.stream()
				.map(car -> modelMapperService.forResponse().map(car, GetAllCarsResponse.class))
				.collect(Collectors.toList());

		return carsResponse;
	}

	@Override
	public GetByIdCarResponse getById(int id) {
		Car car = carRepository.findById(id).orElseThrow();
		GetByIdCarResponse carResponse = modelMapperService.forResponse().map(car, GetByIdCarResponse.class);

		return carResponse;
	}

	@Override
	public void add(CreateCarRequest createCarRequest) {
		
		State temp = carBusinessRules.checkState(createCarRequest.getState());

		Car car = modelMapperService.forRequest().map(createCarRequest, Car.class);

		car.setState(temp);

		carRepository.save(car);
	}

	@Override
	public void update(UpdateCarRequest updateCarRequest) {
		
		State temp = carBusinessRules.checkState(updateCarRequest.getState());

		Car car = modelMapperService.forRequest().map(updateCarRequest, Car.class);

		car.setState(temp);

		carRepository.save(car);
	}

	@Override
	public void delete(int id) {
		this.carRepository.deleteById(id);
	}

}