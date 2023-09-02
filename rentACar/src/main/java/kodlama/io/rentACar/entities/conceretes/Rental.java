package kodlama.io.rentACar.entities.conceretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rentals")
public class Rental {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "car_id")
	private Car car;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "rentDate")
	@JsonFormat(pattern = "dd/MM/yyyy")
	Date rentDate;

	@Column(name = "returnDate")
	@JsonFormat(pattern = "dd/MM/yyyy")
	Date returnDate;

	@Column(name = "totalCost")
	double totalCost;

	@Column(name = "rentDay")
	int rentDay;
}