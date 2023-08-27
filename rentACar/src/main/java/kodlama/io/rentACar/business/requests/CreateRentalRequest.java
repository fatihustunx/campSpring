package kodlama.io.rentACar.business.requests;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRentalRequest {

	@NotNull
	private int carId;

	@NotNull
	private int userId;

	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date rentDate;

	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date returnDate;
}