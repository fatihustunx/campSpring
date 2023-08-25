package kodlama.io.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdAdminResponse {

	private int id;
	private String userFirstName;
	private String userLastName;
	private String companyName;
	private String userEmail;
}
