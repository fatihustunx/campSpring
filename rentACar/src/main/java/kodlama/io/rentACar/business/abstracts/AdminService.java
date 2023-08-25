package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateAdminRequest;
import kodlama.io.rentACar.business.requests.UpdateAdminRequest;
import kodlama.io.rentACar.business.responses.GetAllAdminsResponse;
import kodlama.io.rentACar.business.responses.GetByIdAdminResponse;

public interface AdminService {

	List<GetAllAdminsResponse> getAll();

	GetByIdAdminResponse getById(int id);

	void add(CreateAdminRequest createAdminRequest);

	void update(UpdateAdminRequest updateAdminRequest);

	void delete(int id);
}
