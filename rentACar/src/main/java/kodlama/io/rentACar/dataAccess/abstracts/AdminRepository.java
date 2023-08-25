package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.conceretes.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
