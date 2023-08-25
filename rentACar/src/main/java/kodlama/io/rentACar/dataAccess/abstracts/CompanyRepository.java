package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.conceretes.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
