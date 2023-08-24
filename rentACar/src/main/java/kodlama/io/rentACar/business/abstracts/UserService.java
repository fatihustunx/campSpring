package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateUserRequest;
import kodlama.io.rentACar.business.requests.UpdateUserRequest;
import kodlama.io.rentACar.business.responses.GetAllUsersResponse;
import kodlama.io.rentACar.business.responses.GetByIdUserResponse;

public interface UserService {

	List<GetAllUsersResponse> getAll();
	
	GetByIdUserResponse getById(int id);
	
	void add(CreateUserRequest createUserRequest);
	
	void update(UpdateUserRequest updateUserRequest);
	
	void delete(int id);
}
