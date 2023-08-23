package kodlama.io.rentACar.business.rules;

import java.util.Locale;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.entities.conceretes.enums.State;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarBusinessRules {

	public State checkState(String state) {
		State temp = returnState(state);
		if(temp != null) {
			return temp;
		}else {
			throw new BusinessException("State is not valid !");
		}
	}
	
	private State returnState(String state) {
		for (State s : State.values()) {
			if(s.toString().equals(state)) {
				String temp = state.toUpperCase(Locale.ENGLISH);
				State obj = State.valueOf(temp);
				return obj;
			}
		}
		return null;
	}
}