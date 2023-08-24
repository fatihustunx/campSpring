package kodlama.io.rentACar.business.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

	@NotNull
	@NotBlank
	@Size(min = 2, max = 20)
	private String firstName;

	@NotNull
	@NotBlank
	@Size(min = 2, max = 20)
	private String lastName;

	@NotNull
	@NotBlank
	@Email
	private String email;

	@NotNull
	@NotBlank
	@Size(min = 4, max = 20)
	private String password;
}
