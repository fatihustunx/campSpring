package kodlama.io.rentACar.business.responses;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdRentalResponse {

	private int id;

	private GetByIdCarResponse carResponse;

	private GetByIdUserResponse userResponse;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date rentDate;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date returnDate;

	private double totalCost;

	private int rentDay;
}