package mapper;

import java.text.ParseException;

import org.springframework.stereotype.Component;

import dto.ComputerDto;
import model.Computer;

@Component
public class ComputerMapper {
	private Computer computer;
	

	
	
	public ComputerMapper() {
		
	}


	


	public ComputerDto computerToComputerDto(Computer computer) {
		
		

		ComputerDto computerDto = new ComputerDto(computer.getId(), computer.getName());
		return computerDto;
	}

	public Computer convertFromComputerDtoToComputer(ComputerDto computerDto) throws ParseException {
		Computer computer = new Computer.ComputerBuilder().setId(computerDto.getId()).setName(computerDto.getName()).build();
		return computer;

	}
}
