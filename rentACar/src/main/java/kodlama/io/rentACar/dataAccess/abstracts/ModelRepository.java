package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.conceretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {

	boolean existsByName(String name); // spring jpa keywords !
}
