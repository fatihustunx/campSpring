package kodlama.io.rentACar.business.requests;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAdminRequest {

	@NotNull
	private int userId;

	@NotNull
	private int companyId;
}
