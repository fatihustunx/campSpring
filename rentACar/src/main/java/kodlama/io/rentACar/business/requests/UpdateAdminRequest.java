package kodlama.io.rentACar.business.requests;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAdminRequest {

	@NotNull
	private int id;

	@NotNull
	private int userId;

	@NotNull
	private int companyId;
}
