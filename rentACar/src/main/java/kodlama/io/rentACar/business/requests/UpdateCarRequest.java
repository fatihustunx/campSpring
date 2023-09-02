package kodlama.io.rentACar.business.requests;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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

	@Min(1923)
	@Max(2024)
	private int modelYear;

	@DecimalMin(value = "0.0", inclusive = false)
	private double dailyPrice;

	@NotNull
	private int modelId;

	@NotNull
	@NotBlank
	private String state;
}