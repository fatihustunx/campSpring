package kodlama.io.rentACar.business.conceretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.CompanyService;
import kodlama.io.rentACar.business.requests.CreateCompanyRequest;
import kodlama.io.rentACar.business.requests.UpdateCompanyRequest;
import kodlama.io.rentACar.business.responses.GetAllCompaniesResponse;
import kodlama.io.rentACar.business.responses.GetByIdCompanyResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.CompanyRepository;
import kodlama.io.rentACar.entities.conceretes.Company;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyManager implements CompanyService {

	private CompanyRepository companyRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllCompaniesResponse> getAll() {
		List<Company> companies = companyRepository.findAll();
		List<GetAllCompaniesResponse> companiesResponse = companies.stream()
				.map(company -> modelMapperService.forResponse().map(company, GetAllCompaniesResponse.class))
				.collect(Collectors.toList());

		return companiesResponse;
	}

	@Override
	public GetByIdCompanyResponse getById(int id) {
		Company company = companyRepository.findById(id).orElseThrow();
		GetByIdCompanyResponse companyResponse = modelMapperService.forResponse().map(company,
				GetByIdCompanyResponse.class);

		return companyResponse;
	}

	@Override
	public void add(CreateCompanyRequest createCompanyRequest) {
		Company company = modelMapperService.forRequest().map(createCompanyRequest, Company.class);

		companyRepository.save(company);
	}

	@Override
	public void update(UpdateCompanyRequest updateCompanyRequest) {
		Company company = modelMapperService.forRequest().map(updateCompanyRequest, Company.class);

		companyRepository.save(company);
	}

	@Override
	public void delete(int id) {
		this.companyRepository.deleteById(id);
	}
}
