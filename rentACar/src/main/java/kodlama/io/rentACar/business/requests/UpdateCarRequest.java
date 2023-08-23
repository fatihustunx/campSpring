package kodlama.io.rentACar.business.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarRequest {
	
	@NotNull
	private int id;

	@NotNull
	private int colorId;

	@NotNull
	@NotBlank
	private String plate;

	private int modelYear;

	private double dailyPrice;

	@NotNull
	private int modelId;
	
	@NotNull
	@NotBlank
	private String state;
}