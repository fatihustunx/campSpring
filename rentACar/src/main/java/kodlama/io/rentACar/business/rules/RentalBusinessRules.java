package kodlama.io.rentACar.business.rules;

import java.util.Date;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.entities.conceretes.enums.State;

@Service
public class RentalBusinessRules {

	public void checkCarIsAvailible(String state) {
		if (!state.equals(State.AVAILIBLE.toString())) {
			throw new BusinessException("The car state is not availible !");
		}
	}

	public int returnRentDay(Date rentDate, Date returnDate) {
		int aDay = 86400000;
		Long rentDay = returnDate.getTime() - rentDate.getTime();

		return (int) (rentDay / aDay);
	}

	public double returnTotalCost(double dailyPrice, int rentDay) {
		return rentDay * dailyPrice;
	}

	public void carState() {
		System.out.println(
				"Car state is rented,"
		+ " returnDate -> state is maintenance," 
						+ " admin -> state is availible.");
	}

}