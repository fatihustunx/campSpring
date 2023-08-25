package kodlama.io.rentACar.business.conceretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.AdminService;
import kodlama.io.rentACar.business.requests.CreateAdminRequest;
import kodlama.io.rentACar.business.requests.UpdateAdminRequest;
import kodlama.io.rentACar.business.responses.GetAllAdminsResponse;
import kodlama.io.rentACar.business.responses.GetByIdAdminResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.AdminRepository;
import kodlama.io.rentACar.entities.conceretes.Admin;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminManager implements AdminService {

	private AdminRepository adminRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllAdminsResponse> getAll() {
		List<Admin> admins = adminRepository.findAll();
		List<GetAllAdminsResponse> adminsResponse = admins.stream()
				.map(admin -> modelMapperService.forResponse().map(admin, GetAllAdminsResponse.class))
				.collect(Collectors.toList());

		return adminsResponse;
	}

	@Override
	public GetByIdAdminResponse getById(int id) {
		Admin admin = adminRepository.findById(id).orElseThrow();
		GetByIdAdminResponse adminResponse = modelMapperService.forResponse().map(admin, GetByIdAdminResponse.class);

		return adminResponse;
	}

	@Override
	public void add(CreateAdminRequest createAdminRequest) {
		Admin admin = modelMapperService.forRequest().map(createAdminRequest, Admin.class);

		adminRepository.save(admin);

	}

	@Override
	public void update(UpdateAdminRequest updateAdminRequest) {
		Admin admin = modelMapperService.forRequest().map(updateAdminRequest, Admin.class);

		adminRepository.save(admin);
	}

	@Override
	public void delete(int id) {
		this.adminRepository.deleteById(id);
	}
}
