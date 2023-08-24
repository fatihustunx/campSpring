package kodlama.io.rentACar.dataAccess.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.conceretes.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

	List<Car> findByModelBrandIdAndModelIdAndColorId(Optional<Integer> brandId, Optional<Integer> modelId,
			Optional<Integer> colorId);

	List<Car> findByModelBrandIdAndModelId(Optional<Integer> brandId, Optional<Integer> modelId);

	List<Car> findByModelBrandIdAndColorId(Optional<Integer> brandId, Optional<Integer> colorId);

	List<Car> findByModelIdAndColorId(Optional<Integer> modelId, Optional<Integer> colorId);

	List<Car> findByModelBrandId(Optional<Integer> brandId);

	List<Car> findByModelId(Optional<Integer> modelId);

	List<Car> findByColorId(Optional<Integer> colorId);

}