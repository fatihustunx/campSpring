package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.conceretes.Rental;

public interface RentalRepository extends JpaRepository<Rental, Integer> {

}
