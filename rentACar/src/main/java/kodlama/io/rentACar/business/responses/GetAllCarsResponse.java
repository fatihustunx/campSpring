package kodlama.io.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCarsResponse {

	private int id;
	private String plate;
	private String colorName;
	private int modelYear;
	private double dailyPrice;
	private String modelBrandName;
	private String modelName;
	private String state;
}
