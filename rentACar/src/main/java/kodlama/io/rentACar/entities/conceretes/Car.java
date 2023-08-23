package kodlama.io.rentACar.entities.conceretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import kodlama.io.rentACar.entities.conceretes.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "plate", unique = true)
	private String plate;

	@ManyToOne
	@JoinColumn(name="color_id")
	private Color color;
	
	@Column(name = "modelYear")
	private int modelYear;
	
	@Column(name = "dailyPrice")
	private double dailyPrice;

	@ManyToOne
	@JoinColumn(name = "model_id")
	private Model model;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "state")
	private State state;
}
