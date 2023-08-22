package kodlama.io.rentACar.business.conceretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ColorService;
import kodlama.io.rentACar.business.requests.CreateColorRequest;
import kodlama.io.rentACar.business.requests.UpdateColorRequest;
import kodlama.io.rentACar.business.responses.GetAllColorsResponse;
import kodlama.io.rentACar.business.responses.GetByIdColorResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ColorRepository;
import kodlama.io.rentACar.entities.conceretes.Color;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {

	private ColorRepository colorRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllColorsResponse> getAll() {
		List<Color> colors = colorRepository.findAll();
		List<GetAllColorsResponse> colorsResponse = colors.stream()
				.map(color -> this.modelMapperService.forResponse().map(color, GetAllColorsResponse.class))
				.collect(Collectors.toList());
		
		return colorsResponse;
	}

	@Override
	public GetByIdColorResponse getById(int id) {
		Color color = colorRepository.findById(id).orElseThrow();
		GetByIdColorResponse colorResponse = this.modelMapperService.forResponse().map(color, GetByIdColorResponse.class);
		return colorResponse;
	}

	@Override
	public void add(CreateColorRequest createColorRequest) {
		this.colorRepository.save(modelMapperService.forRequest().map(createColorRequest, Color.class));

	}

	@Override
	public void update(UpdateColorRequest updateColorRequest) {
		this.colorRepository.save(modelMapperService.forRequest().map(updateColorRequest, Color.class));
	}

	@Override
	public void delete(int id) {
		this.colorRepository.deleteById(id);
	}

}
