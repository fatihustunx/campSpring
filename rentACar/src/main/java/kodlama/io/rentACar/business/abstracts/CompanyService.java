package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateCompanyRequest;
import kodlama.io.rentACar.business.requests.UpdateCompanyRequest;
import kodlama.io.rentACar.business.responses.GetAllCompaniesResponse;
import kodlama.io.rentACar.business.responses.GetByIdCompanyResponse;

public interface CompanyService {

	List<GetAllCompaniesResponse> getAll();

	GetByIdCompanyResponse getById(int id);

	void add(CreateCompanyRequest createCompanyRequest);

	void update(UpdateCompanyRequest updateCompanyRequest);

	void delete(int id);
}
