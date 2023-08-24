package kodlama.io.rentACar.business.conceretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.UserService;
import kodlama.io.rentACar.business.requests.CreateUserRequest;
import kodlama.io.rentACar.business.requests.UpdateUserRequest;
import kodlama.io.rentACar.business.responses.GetAllUsersResponse;
import kodlama.io.rentACar.business.responses.GetByIdUserResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.UserRepository;
import kodlama.io.rentACar.entities.conceretes.User;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

	private UserRepository userRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllUsersResponse> getAll() {
		List<User> users = userRepository.findAll();
		List<GetAllUsersResponse> usersResponse = users.stream()
				.map(user -> modelMapperService.forResponse().map(user, GetAllUsersResponse.class))
				.collect(Collectors.toList());

		return usersResponse;
	}

	@Override
	public GetByIdUserResponse getById(int id) {
		User user = userRepository.findById(id).orElseThrow();
		GetByIdUserResponse userResponse = modelMapperService.forResponse().map(user, GetByIdUserResponse.class);

		return userResponse;
	}

	@Override
	public void add(CreateUserRequest createUserRequest) {
		User user = modelMapperService.forRequest().map(createUserRequest, User.class);

		userRepository.save(user);
	}

	@Override
	public void update(UpdateUserRequest updateUserRequest) {
		User user = modelMapperService.forRequest().map(updateUserRequest, User.class);

		userRepository.save(user);
	}

	@Override
	public void delete(int id) {
		this.userRepository.deleteById(id);
	}
}