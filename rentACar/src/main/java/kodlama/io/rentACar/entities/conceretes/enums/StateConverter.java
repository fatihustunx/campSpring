package kodlama.io.rentACar.entities.conceretes.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

//@Converter(autoApply = true)
public class StateConverter implements AttributeConverter<State, String> {

	@Override
	public String convertToDatabaseColumn(State attribute) {
		/*
		 * if(attribute == null) { return null; } return attribute.toString();
		 */
		return null;
	}

	@Override
	public State convertToEntityAttribute(String dbData) {
		/*
		 * if(dbData==null) { return null; } return Stream.of(State.values()).filter(s
		 * ->
		 * s.toString().equals(dbData)).findFirst().orElseThrow(IllegalArgumentException
		 * ::new);
		 */
		return null;
	}
}